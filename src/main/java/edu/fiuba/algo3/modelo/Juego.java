package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Etapa.*;
import edu.fiuba.algo3.modelo.exception.ExcepcionFinDeJuego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoPaises;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoTarjetas;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Juego { 
  
    private HashMap<String, TarjetaPais> tarjetasDePais;
    private final ArrayList<Jugador> listaJugadores;
    private final Tablero tablero;

    private Jugador jugadorActual;
    private Jugador ultimoJugador;
    private EtapaR etapaR;
    private ArrayList<Jugador> turnos;
    private int cantidadPaisesJugadorActual;
    private ArrayList<Color> coloresFichas;

    public Juego(int cantidadJugadores) {
        listaJugadores = new ArrayList<>();
        tablero = new Tablero();
        cargarColores();
        for (int i = 0; i < cantidadJugadores; i++) {
            this.listaJugadores.add(new Jugador());
        }
        LecturaArchivoTarjetas cargarTarjetas = new LecturaArchivoTarjetas();
        if (cargarTarjetas.leerArchivos()){ this.tarjetasDePais = cargarTarjetas.getTarjetas(); }
        LecturaArchivoPaises cargarPaises = new LecturaArchivoPaises();
        cargarPaises.leerArchivo(this.tarjetasDePais, this.tablero);
    }

    public void repartirPaisesCondicionesConocidas(){ //condicionesControladasParaTesteo
        int i = 0;
        while(this.tarjetasDePais.size() > 0) {
            List<TarjetaPais> tarjetas = new ArrayList<>(tarjetasDePais.values());
            TarjetaPais tarjeta = tarjetas.get(0);
            this.entregarTarjeta(listaJugadores.get(i% listaJugadores.size()), tarjeta);
            i ++;
        }
    }

    public void repartirPaises(){ //forma aleatoria para juego final
        int i = 0;
        while(this.tarjetasDePais.size() > 0) {
            List<TarjetaPais> tarjetas = new ArrayList<>(tarjetasDePais.values());
            int num = (int)Math.floor(Math.random()*(tarjetasDePais.size()));
            TarjetaPais tarjeta = tarjetas.get(num);
            this.entregarTarjeta(listaJugadores.get(i% listaJugadores.size()), tarjeta);
            i ++;
        }
    }

    public void ocuparTablero(){
        for (Jugador jugador : listaJugadores) {
            ArrayList<TarjetaPais> tarjetas = jugador.ocuparPaises();
            this.guardarTarjetas(tarjetas);
        }
    }

    public void guardarTarjetas(ArrayList<TarjetaPais> tarjetas){
        for (TarjetaPais tarjeta : tarjetas) {
            this.tarjetasDePais.put(tarjeta.obtenerPais().obtenerNombre(), tarjeta);
        }
    }

    public void iniciarJuegoPrueba(){
        this.repartirPaisesCondicionesConocidas();
        this.ocuparTablero();
        this.turnos = new ArrayList<>(listaJugadores);
        jugadorActual = turnos.get(0);
        this.faseInicial();
        ultimoJugador = turnos.get(turnos.size()-1);
        this.configurarJugadoresDePrueba();

    }

    public void jugar(){
        this.repartirPaises();
        this.ocuparTablero();
        this.turnos = new ArrayList<>(listaJugadores);
        jugadorActual = turnos.get(0);
        this.faseInicial();
        ultimoJugador = turnos.get(turnos.size()-1);
        this.configurarJugadoresDePrueba();
    }

    public void faseInicial(){ etapaR = new EtapaR1(this); }

    public Pais obtenerPais(String pais){   return tablero.obtenerPais(pais); }

    public void colocarEjercitosPaisNombre(String nombrePais, int cantidad){
        Pais pais = this.obtenerTablero().obtenerPais(nombrePais);
        colocarEjercitosFaseInicial(pais, cantidad);

    }
    public void colocarEjercitosFaseInicial(Pais pais, int cantidad){
        etapaR.colocarEjercitos(jugadorActual, pais, cantidad);
    }
    public void pasarTurno(){
        if(etapaR.estaTerminada()) {
            if(etapaR.getClass() == EtapaRAtacar.class){
                etapaR = etapaR.pasarEtapa();
            }
            else {
                if (jugadorActual == ultimoJugador) {
                    etapaR = etapaR.pasarEtapa();
                }
                if (jugadorActual != ultimoJugador && etapaR.getClass() == EtapaRReagrupar.class) {
                    etapaR = new EtapaRAtacar(this);
                }

                turnos.add(turnos.remove(0));
                jugadorActual = turnos.get(0);
                cantidadPaisesJugadorActual = tablero.obtenerCantidadPaisesJugador(jugadorActual);
                etapaR.establecerCantidadEjercitos(cantidadPaisesJugadorActual / 2);
            }
        }
    }
    public String obtenerJugadorActual(){
        return turnos.get(0).obtenerNombre();
    }
    public String obtenerSiguienteJugador(){
        return turnos.get(1).obtenerNombre();
    }
    public EtapaR obtenerEtapaR() {
        return etapaR;
    }

    public int cantidadEjercitosDisponibles(){
        return this.etapaR.obtenerCantidadEjercitos();
    }

    public void atacarDesdeA(String nombreAtacante, String nombreDefensor){
        Pais atacante = this.obtenerPais(nombreAtacante);
        Pais defensor = this.obtenerPais(nombreDefensor);
        this.atacarACon(atacante, defensor);
    }
    public void atacarACon(Pais atacante, Pais defensor) {
        etapaR.AtacarCon(jugadorActual, atacante, defensor);
        if(tablero.obtenerCantidadPaisesJugador(jugadorActual) >= 30) {
            this.finalizar(jugadorActual.obtenerNombre());
        }
    }

    public void finalizar(String nombre) {
      throw new ExcepcionFinDeJuego("Fin del juego. Felicidades: " + nombre);
    }

    public void terminarAtaques(){
        if(cantidadPaisesJugadorActual != tablero.obtenerCantidadPaisesJugador(jugadorActual)){
            this.entregarTarjetaRandom(jugadorActual);
        }
    }

    public void entregarTarjetaRandom(Jugador jugador){
        ArrayList<String> tarjetas = new ArrayList<>(tarjetasDePais.keySet());
        int numeroRandom = new Random().nextInt(tarjetas.size());
        String claveRandom = tarjetas.get(numeroRandom);
        jugador.agregarTarjeta(tarjetasDePais.remove(claveRandom));
    }
    public void transferirEjercitosDeA(String nombrePaisOrigen, String nombrePaisDestino, int cantidadEjercitos){
        Pais paisOrigen = this.obtenerPais(nombrePaisOrigen);
        Pais paisDestino = this.obtenerPais(nombrePaisDestino);
        this.transferirEjercitos(paisOrigen, paisDestino, cantidadEjercitos);
    }
    public void transferirEjercitos(Pais aliado1, Pais aliado2, int cantidadEjercitos) {
        etapaR.transferirEjercitos(jugadorActual, aliado1, aliado2, cantidadEjercitos);
    }

    public TarjetaPais obtenerTarjeta(String nombreTarjeta){
        return tarjetasDePais.get(nombreTarjeta);
    }


    public void entregarTarjeta(Jugador unJugador, TarjetaPais tarjeta){
        unJugador.agregarTarjeta(tarjeta);
        this.tarjetasDePais.remove(tarjeta.obtenerPais().obtenerNombre());
    }

    public int obtenerEjercitos(Jugador jugador){
        int cantidadPaises = this.tablero.obtenerCantidadPaisesJugador(jugador);

        return (this.tablero.fichasContinente(jugador) + cantidadPaises/2);
    }

    public Jugador obtenerJugador(int numeroDeJugador){
        return this.listaJugadores.get(numeroDeJugador - 1);
    }

    public Tablero obtenerTablero(){
        return this.tablero;
    }

    public Object obtenerTarjetas() {
        return tarjetasDePais.values();
    }

    public ArrayList<Pais> obtenerPaises() {
        return tablero.obtenerPaises();
    }

    public void cargarColores(){
        this.coloresFichas = new ArrayList<>();
        
        Color rojo,verde,azul,blanco,negro,violeta;
        rojo    = Color.RED;
        verde   = Color.GREEN;
        azul    = Color.BLUE;
        blanco  = Color.WHITE;
        negro   = Color.BLACK;
        violeta = Color.VIOLET;

        this.coloresFichas.add(rojo);
        this.coloresFichas.add(verde);
        this.coloresFichas.add(azul);
        this.coloresFichas.add(blanco);
        this.coloresFichas.add(negro);
        this.coloresFichas.add(violeta);

    }

    public void establecerNombreJugador(Jugador unJugador, String unNombre) {
        unJugador.establecerNombre(unNombre);
    }

    public void establecerColorAJugador(Jugador unJugador, Color unColor) {
        unJugador.establecerColorFicha(unColor);
    }

    public void configurarJugadoresDePrueba() {
        String[] nombres = {"Juani","Cris","Pedro","Roby"};
        int i = 0;
        for (Jugador unJugador : listaJugadores) {
            this.establecerNombreJugador(unJugador, nombres[i]);
            this.establecerColorAJugador(unJugador, this.coloresFichas.get(i));
            i++;
        }
    }

}