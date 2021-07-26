package edu.fiuba.algo3.modelo;

import java.util.*;

import edu.fiuba.algo3.modelo.Etapa.EtapaR;
import edu.fiuba.algo3.modelo.Etapa.EtapaRReagrupar;
import edu.fiuba.algo3.modelo.Etapa.EtapaRinicial;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoPaises;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoTarjetas;

public class Juego { 
  
    private HashMap<String, TarjetaPais> tarjetasDePais;
    private final ArrayList<Jugador> listaJugadores;
    private final Tablero tablero;

    private Jugador jugadorActual;
    private Jugador ultimoJugador;
    private EtapaR etapaR;
    private ArrayList<Jugador> turnos;
    private int cantidadPaisesJugadorActual;

    public Juego(int cantidadJugadores) {
        listaJugadores = new ArrayList<>();
        tablero = new Tablero();
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

    public void iniciarJuego(){
        this.repartirPaisesCondicionesConocidas();
        this.ocuparTablero();
        this.turnos = new ArrayList<>(listaJugadores);
    }

    public void jugar(){
        jugadorActual = turnos.get(0);
        this.faseInicial();
        ultimoJugador = turnos.get(turnos.size()-1);
    }

    public void faseInicial(){ etapaR = new EtapaRinicial(); }

    public Pais obtenerPais(String pais){   return tablero.obtenerPais(pais); }

    public void colocarCincoEjercitosFaseInicial(Pais pais){
        etapaR.colocarEjercitos(jugadorActual, pais, 5);
    }

    public void pasarTurno(){
        if(jugadorActual == ultimoJugador){ etapaR = etapaR.pasarEtapa(); }
        turnos.add( turnos.remove(0));
        jugadorActual = turnos.get(0);
        cantidadPaisesJugadorActual = tablero.obtenerCantidadPaisesJugador(jugadorActual);
    }

    public EtapaR obtenerEtapaR() {
        return etapaR;
    }

    public void atacarACon(Pais atacante, Pais defensor) {

        etapaR.AtacarCon(jugadorActual, atacante, defensor);
    }

    public void terminarAtaques(){
        if(cantidadPaisesJugadorActual != tablero.obtenerCantidadPaisesJugador(jugadorActual)){
            this.entregarTarjetaRandom(jugadorActual);
        }
        etapaR = new EtapaRReagrupar();
    }
    public void entregarTarjetaRandom(Jugador jugador){
        ArrayList<String> tarjetas = new ArrayList<>(tarjetasDePais.keySet());
        int numeroRandom = new Random().nextInt(tarjetas.size());
        String claveRandom = tarjetas.get(numeroRandom);
        jugador.agregarTarjeta(tarjetasDePais.remove(claveRandom));
    }

    public void tranferirEjercitos(Pais aliado1, Pais aliado2, int cantidadEjercitos) {
        etapaR.tranferirEjercitos(jugadorActual, aliado1, aliado2, cantidadEjercitos);
    }

    public TarjetaPais obtenerTarjeta(String nombreTarjeta){
        return tarjetasDePais.get(nombreTarjeta);
    }


    public void entregarTarjeta(Jugador unJugador, TarjetaPais tarjeta){
        unJugador.agregarTarjeta(tarjeta);
        this.tarjetasDePais.remove(tarjeta.obtenerPais().obtenerNombre());
    }

    public int obtenerEjercitos(Jugador jugador){
        int cantidadPaises = 0;
        cantidadPaises = this.tablero.obtenerCantidadPaisesJugador(jugador);

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
}