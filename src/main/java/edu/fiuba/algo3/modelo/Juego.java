package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Etapa.*;
import edu.fiuba.algo3.modelo.exception.ExcepcionFinDeJuego;
import edu.fiuba.algo3.modelo.exception.ExcepcionPasarTurnoNoEsPosible;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoObjetivos;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoPaises;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoTarjetas;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
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
    private Etapa etapa;
    private ArrayList<Jugador> turnos;
    private int cantidadPaisesJugadorActual;
    private ArrayList<Color> coloresFichas;
    private ArrayList<String> nombreColoresFichas;
    private final ArrayList<Objetivo> objetivos;

    /**
     * Constructor del juego.
     * @param cantidadJugadores -> n° jugadores.
     */
    public Juego(int cantidadJugadores) {
        listaJugadores = new ArrayList<>();
        tablero = new Tablero();
        objetivos = new ArrayList<>();
        cargarColores();
        for (int i = 0; i < cantidadJugadores; i++) {
            this.listaJugadores.add(new Jugador());
        }
        LecturaArchivoTarjetas cargarTarjetas = new LecturaArchivoTarjetas();
        if (cargarTarjetas.leerArchivos()) {
            this.tarjetasDePais = cargarTarjetas.getTarjetas();
        }
        LecturaArchivoPaises cargarPaises = new LecturaArchivoPaises();
        cargarPaises.leerArchivo(this.tarjetasDePais, this.tablero);
        LecturaArchivoObjetivos cargarObjetivos = new LecturaArchivoObjetivos();
        cargarObjetivos.leerArchivo(objetivos);
    }

    /** 
     * Reparte los paises en condiciones conocidas para testeo.
    */
    public void repartirPaisesCondicionesConocidas() {
        int i = 0;
        while (this.tarjetasDePais.size() > 0) {
            List<TarjetaPais> tarjetas = new ArrayList<>(tarjetasDePais.values());
            TarjetaPais tarjeta = tarjetas.get(0);
            this.entregarTarjeta(listaJugadores.get(i % listaJugadores.size()), tarjeta);
            i++;
        }
    }

    /**
     * Reparte los paises aleatoriamente para el inicio del juego.
     */
    public void repartirPaises() { 
        int i = 0;
        while (this.tarjetasDePais.size() > 0) {
            List<TarjetaPais> tarjetas = new ArrayList<>(tarjetasDePais.values());
            int num = (int) Math.floor(Math.random() * (tarjetasDePais.size()));
            TarjetaPais tarjeta = tarjetas.get(num);
            this.entregarTarjeta(listaJugadores.get(i % listaJugadores.size()), tarjeta);
            i++;
        }
    }

    /** 
     * Ocupa los paises del tablero asignandoles un ejercito a cada uno
     * y les quita la TarjetaPais correspondiente.
     */
    public void ocuparTablero() {
        for (Jugador jugador : listaJugadores) {
            ArrayList<TarjetaPais> tarjetas = jugador.ocuparPaises();
            this.guardarTarjetas(tarjetas);
        }
    }

    /**
     * Guarda el ArrayList<TarjetaPais> en un HashMap<String, TarjetaPais>
     * @param tarjetas -> array de tarjetas
     */
    public void guardarTarjetas(ArrayList<TarjetaPais> tarjetas) {
        for (TarjetaPais tarjeta : tarjetas) {
            this.tarjetasDePais.put(tarjeta.obtenerPais().obtenerNombre(), tarjeta);
        }
    }

    /**
     * Inicia el juego con condiciones para testeo.<p>
     <pre>.    NOMBRE   | COLOR | OBJ
     -------------------------------
     Juani    | Rojo  | ocupar varios
     Cris     | Amar  | ocupar Asur y Africa
     Pedro    | Verde | destruir rojo
     Roby     | Azul  | destruir violeta
     </pre>
     */
    public void iniciarJuegoPrueba() {
        this.repartirPaisesCondicionesConocidas();
        this.ocuparTablero();
        this.turnos = new ArrayList<>(listaJugadores);
        jugadorActual = turnos.get(0);
        this.faseInicial();
        ultimoJugador = turnos.get(turnos.size() - 1);
        this.configurarJugadoresDePrueba();
        this.repartirObjetivosCondicionesConocidas();

    }

    private void repartirObjetivosCondicionesConocidas() {

        this.listaJugadores.get(0).establecerObjetivo(this.objetivos.get(5)); // ocupar paises varios
        this.objetivos.get(5).asignarJugador(this.listaJugadores.get(0));

        this.listaJugadores.get(1).establecerObjetivo(this.objetivos.get(7)); // ocupar Asur y Africa. 
        this.objetivos.get(7).asignarJugador(this.listaJugadores.get(1));

        if (this.listaJugadores.size() > 2){
        this.listaJugadores.get(2).establecerObjetivo(this.objetivos.get(9)); // destruir Rojo
        this.objetivos.get(9).asignarJugador(this.listaJugadores.get(2));
        }
        
        if (this.listaJugadores.size() > 3){
        this.listaJugadores.get(3).establecerObjetivo(this.objetivos.get(13)); // destruir verde
        this.objetivos.get(13).asignarJugador(this.listaJugadores.get(3));
        }

    }

    public void jugar(){
        this.repartirPaisesCondicionesConocidas();
    //    this.repartirPaises();
        this.ocuparTablero();
        this.repartirObjetivos();
        this.turnos = new ArrayList<>(listaJugadores);
        jugadorActual = turnos.get(0);
        cantidadPaisesJugadorActual = tablero.obtenerCantidadPaisesJugador(jugadorActual);
        this.faseInicial();
        ultimoJugador = turnos.get(turnos.size() - 1);
        this.configurarJugadoresDePrueba();
    }

    private void repartirObjetivos() {
        int i = 0;
        for(Jugador jugador: listaJugadores){
            jugador.establecerObjetivo(objetivos.get(i));
            i++;
        }
    }

    /**
     * inicializa la fase inicial con la primera etapa.
     */
    public void faseInicial() {
        etapa = new EtapaColocacionRondaUno(this);
    }

    /**
     * Obtener el objeto Pais segun su nombre.
     * @param pais -> string nombre
     * @return objeto Pais.
     */
    public Pais obtenerPais(String pais) {
        return tablero.obtenerPais(pais);
    }

    public void colocarEjercitosPaisNombre(String nombrePais, int cantidad) {
        Pais pais = this.obtenerTablero().obtenerPais(nombrePais);
        colocarEjercitosFaseInicial(pais, cantidad);

    }

    public void colocarEjercitosFaseInicial(Pais pais, int cantidad) {
        etapa.colocarEjercitos(jugadorActual, pais, cantidad);
    }
    public void pasarTurno(){
        if(etapa.estaTerminada()) {
            if(etapa.getClass() == EtapaAtacar.class){
                etapa = etapa.pasarEtapa();
            } else {
                if (jugadorActual == ultimoJugador) {
                    etapa = etapa.pasarEtapa();
                }
                if (jugadorActual != ultimoJugador && etapa.getClass() == EtapaReagrupar.class) {
                    etapa = new EtapaAtacar(this);
                }
                turnos.add(turnos.remove(0));
                jugadorActual = turnos.get(0);
                cantidadPaisesJugadorActual = tablero.obtenerCantidadPaisesJugador(jugadorActual);
                etapa.establecerCantidadEjercitos(obtenerEjercitos(jugadorActual));
            }
        }else{
            throw new ExcepcionPasarTurnoNoEsPosible("No es posible Pasar el turno, sin haber agregado todos los ejercitos disponibles");
        }
    }
    public String obtenerJugadorActual(){
        return turnos.get(0).obtenerNombre();
    }

    public String obtenerSiguienteJugador(){
        return turnos.get(1).obtenerNombre();
    }

    public Etapa obtenerEtapaR() {
        return etapa;
    }

    public int cantidadEjercitosDisponibles(){
        return this.etapa.obtenerCantidadEjercitos();
    }

    public void atacarDesdeA(String nombreAtacante, String nombreDefensor){
        Pais atacante = this.obtenerPais(nombreAtacante);
        Pais defensor = this.obtenerPais(nombreDefensor);
        this.atacarACon(atacante, defensor);
    }
    public void atacarACon(Pais atacante, Pais defensor) {
        etapa.AtacarCon(jugadorActual, atacante, defensor);
        /*
        jugadorActual.objetivo().actualizar(this);
        if(jugadorActual.objetivo().estaCumplido()) {
            throw new ExcepcionFinDeJuego(jugadorActual.obtenerNombre() + " Felicidades haz ganado el juego!");
        }
        */
    }
    public void activarTarjetaPais(String nombrePais){
        jugadorActual.activarTarjetaPais(jugadorActual.obtenerTarjeta(nombrePais));
    }
    public void finalizar(String nombre) {
        throw new ExcepcionFinDeJuego("Fin del juego. Felicidades: " + nombre);
    }

    public void terminarAtaques() {
        if (cantidadPaisesJugadorActual != tablero.obtenerCantidadPaisesJugador(jugadorActual)) {
            this.entregarTarjetaRandom(jugadorActual);
        }
    }


    /**
    Verifica si hay ganador del juego segun objetivos.
    @return Jugador ganador, si no hay ganador devuelve null.
    */
    public Jugador hayGanador() {
        for (Jugador unJug : this.listaJugadores) {
            if (unJug.objetivo().estaCumplido())
                return unJug;
        }
        return null;
    }

    public void realizarCanje(ArrayList<String> tarjetas){
        int cantidadEjercitos;
        ArrayList<TarjetaPais> tarjetasCanje = new ArrayList<>();
        for(String tarjeta: tarjetas){
            TarjetaPais tarjetaPais = jugadorActual.obtenerTarjeta(tarjeta);
            tarjetasCanje.add(tarjetaPais);
        }
        cantidadEjercitos = jugadorActual.canjearTarjetas(tarjetasCanje);
        etapa.agregarEjercitosCanje(cantidadEjercitos);
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
        etapa.transferirEjercitos(jugadorActual, aliado1, aliado2, cantidadEjercitos);
    }

    public TarjetaPais obtenerTarjeta(String nombreTarjeta) {
        return tarjetasDePais.get(nombreTarjeta);
    }

    public void entregarTarjeta(Jugador unJugador, TarjetaPais tarjeta) {
        unJugador.agregarTarjeta(tarjeta);
        this.tarjetasDePais.remove(tarjeta.obtenerPais().obtenerNombre());
    }

    public int obtenerEjercitos(Jugador jugador) {
        int cantidadPaises = this.tablero.obtenerCantidadPaisesJugador(jugador);


        return (this.tablero.fichasContinente(jugador) + (cantidadPaises/2));

    }

    /**
     * Recibe un numero de jugador y devuelve su Objeto Jugador.
     * @param numeroDeJugador -> numero, no indice. 
     * @return Objeto Jugador
     */
    public Jugador obtenerJugador(int numeroDeJugador) {
        return this.listaJugadores.get(numeroDeJugador - 1);
    }

    public void establecerNombreColorJugador(int numeroDeJugador, String unColor) {
        this.listaJugadores.get(numeroDeJugador - 1).nombreColor(unColor);

    }

    public Tablero obtenerTablero() {
        return this.tablero;
    }

    public ArrayList<TarjetaPais> obtenerTarjetas() {
        return new ArrayList<>(tarjetasDePais.values());
    }

    public ArrayList<Pais> obtenerPaises() {
        return tablero.obtenerPaises();
    }

    public Jugador obtenerJugadorJugando(){
        return jugadorActual;
    }

    public void cargarColores(){
        this.coloresFichas = new ArrayList<>();
        this.nombreColoresFichas = new ArrayList<>();

        Color rojo, verde, azul, blanco, negro, violeta, amarillo;
        rojo = Color.RED;
        verde = Color.GREEN;
        azul = Color.BLUE;
        blanco = Color.WHITE;
        negro = Color.BLACK;
        violeta = Color.VIOLET;
        amarillo = Color.YELLOW;

        this.coloresFichas.add(rojo);
        this.coloresFichas.add(amarillo);
        this.coloresFichas.add(verde);
        this.coloresFichas.add(azul);
        this.coloresFichas.add(blanco);
        this.coloresFichas.add(negro);
        this.coloresFichas.add(violeta);

        this.nombreColoresFichas.add("rojo");
        this.nombreColoresFichas.add("amarillo");
        this.nombreColoresFichas.add("verde");
        this.nombreColoresFichas.add("azul");
        this.nombreColoresFichas.add("blanco");
        this.nombreColoresFichas.add("negro");
        this.nombreColoresFichas.add("violeta");

    }

    public void establecerNombreJugador(Jugador unJugador, String unNombre) {
        unJugador.establecerNombre(unNombre);
    }

    public void establecerColorAJugador(Jugador unJugador, Color unColor) {
        unJugador.establecerColorFicha(unColor);
    }

    public void configurarJugadoresDePrueba() {
        String[] nombres = { "Juani", "Cris", "Pedro", "Roby" };
        int i = 0;
        for (Jugador unJugador : listaJugadores) {
            this.establecerNombreJugador(unJugador, nombres[i]);
            this.establecerColorAJugador(unJugador, this.coloresFichas.get(i));
            this.establecerNombreColorJugador(i+1, this.nombreColoresFichas.get(i));
            i++;
        }
    }

    public boolean existeColor(String color) {
        boolean existeColor = false;
        for (Jugador j : this.turnos) {
            if (j.color().equalsIgnoreCase(color))
                existeColor = true;
        }
        return existeColor;
    }

    /**
     * Busca en los turnos del juego y devuelve el jugador que le sigue.
     * @param jugador -> jugador actual
     * @return -> jugador que le sigue
     */
    public Jugador siguienteJugador(Jugador jugador) {
        for (int i = 0; i < turnos.size(); i++) {
            if (turnos.get(i).equals(jugador) && (i < turnos.size() - 1))
                return turnos.get(i + 1);
            else if (turnos.get(i).equals(jugador))
                return turnos.get(0);
        }
        return null;
    }

    public void actualizarObjetivos(){
        for (Objetivo o : this.objetivos) {
            o.actualizar(this);
        }
    }

    public Jugador obtenerJugadorPorColor(String equipoADestruir) {
        for (Jugador j : this.listaJugadores) {
            if (j.color().equalsIgnoreCase(equipoADestruir))
                return j;
        }
        return null;
    }

    public Boolean tienePaises(Jugador unJugador) {
        return this.tablero.obtenerCantidadPaisesJugador(unJugador) != 0;
    }

    public boolean objetivoCumplido(Jugador unJug) {
        return unJug.objetivoCumplido();
    }

}