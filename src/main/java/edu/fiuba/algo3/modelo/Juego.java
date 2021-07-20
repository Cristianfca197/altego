package edu.fiuba.algo3.modelo;

import java.util.*;

public class Juego { 
  
    private HashMap<String, TarjetaPais> tarjetasDePais;
    private ArrayList<Jugador> listaJugadores;
    private LecturaArchivoTarjetas cargarTarjetas = new LecturaArchivoTarjetas();
    private LecturaArchivoPaises cargarPaises = new LecturaArchivoPaises();
    private Tablero tablero;

    public Juego(int cantidadJugadores) {
        listaJugadores = new ArrayList<>();
        tablero = new Tablero();
        for (int i = 0; i < cantidadJugadores; i++) {
            this.listaJugadores.add(new Jugador());
        }
        if (cargarTarjetas.leerArchivos()){ this.tarjetasDePais = cargarTarjetas.getTarjetas(); }
        cargarPaises.leerArchivo(this.tarjetasDePais, this.tablero);
    }
    public TarjetaPais obtenerTarjeta(String nombreTarjeta){
        return tarjetasDePais.get(nombreTarjeta);
    }
    public void repartirPaisesCondicionesConocidas(){ //condicionesControladasParaTesteo
        int i = 0;
        while(this.tarjetasDePais.size() > 0) {
            List<TarjetaPais> tarjetas = new ArrayList<TarjetaPais>(tarjetasDePais.values());
            TarjetaPais tarjeta = tarjetas.get(0);
            this.entregarTarjeta(listaJugadores.get(i% listaJugadores.size()), tarjeta);
            i ++;
        }
    }
    public void repartirPaises(){ //forma aleatoria para juego final
        int i = 0;
        while(this.tarjetasDePais.size() > 0) {
            List<TarjetaPais> tarjetas = new ArrayList<TarjetaPais>(tarjetasDePais.values());
            int num = (int)Math.floor(Math.random()*(tarjetasDePais.size()));
            TarjetaPais tarjeta = tarjetas.get(num);
            this.entregarTarjeta(listaJugadores.get(i% listaJugadores.size()), tarjeta);
            i ++;
        }
    }
    public void entregarTarjeta(Jugador unJugador, TarjetaPais tarjeta){
        unJugador.obtenerTarjeta(tarjeta);
        this.tarjetasDePais.remove(tarjeta.obtenerPais().obtenerNombre());
    }
    public void ocuparTablero(){
        for (int i = 0; i < listaJugadores.size(); i++) {
            ArrayList<TarjetaPais> tarjetas = listaJugadores.get(i).ocuparPaises();
            this.guardarTarjetas(tarjetas);

        }
    }
    public void guardarTarjetas(ArrayList<TarjetaPais> tarjetas){
        for (int i = 0; i < tarjetas.size(); i++) {
            this.tarjetasDePais.put(tarjetas.get(i).obtenerPais().obtenerNombre(), tarjetas.get(i));
        }

    }
    public void entregarTarjetas(){
        for (TarjetaPais tarjetaPais: this.tarjetasDePais.values()){
            System.out.println(tarjetaPais.obtenerTipo());
            System.out.println(tarjetaPais.obtenerPais().obtenerNombre());
        }
    }
    public void entregarPaises(){
        for (TarjetaPais tarjetaPais: this.tarjetasDePais.values()){
            System.out.println(tarjetaPais.obtenerPais().obtenerNombre());
            System.out.println(tarjetaPais.obtenerPais().continenteNombre());
            
            ArrayList<Pais> limitrofes = tarjetaPais.obtenerPais().obtenerLimitrofes();
            System.out.printf("Limitrofes de %s:\n",tarjetaPais.obtenerPais().obtenerNombre());

            for (Pais limitrofe: limitrofes){
                System.out.println(limitrofe.obtenerNombre());
            }
            System.out.println("-----------------");
        }
    }
    public void turnoDeColocacion(){

        for (int i = 0; i < this.cantidadDeJugadores(); i++) {
            int cantidadEjercitos = 0;
            Jugador jugador = this.listaJugadores.get(i);
            cantidadEjercitos = this.obtenerEjercitos(jugador);
            jugador.colocarEjercitos(cantidadEjercitos);
        }
    }
    public int obtenerEjercitos(Jugador jugador){
        int cantidadPaises = 0;
        cantidadPaises = this.tablero.obtenerCantidadPaisesJugador(jugador);

        return (this.tablero.fichasContinente(jugador) + cantidadPaises/2);
    }
    public Integer cantidadDeJugadores() {
        return this.listaJugadores.size();
    }
    public Jugador obtenerJugador(int numeroDeJugador){
        return this.listaJugadores.get(numeroDeJugador -1);
    }
    public Tablero obtenerTablero(){
        return this.tablero;
    }

    public void turnoAtacar(){
        for(Jugador jugador: this.listaJugadores){
            boolean seguirAtacando = true;
            while (seguirAtacando) {
                HashMap<String, ArrayList<Pais>> paisesQuePuedeAtacarElJugador = this.obtenerPaisesQuePuedeAtacar(jugador);
                String unaClave = "unPais"; //El jugador selecciona una clave de las de arriba para saber el pais atacante
                jugador.hacerAtaques(tarjetasDePais.get(unaClave).obtenerPais(), paisesQuePuedeAtacarElJugador.get(unaClave));
                seguirAtacando = false; //preguntar al jugador si quiere hace otro ataque
            }
        }
    }

    private HashMap<String, ArrayList<Pais>> obtenerPaisesQuePuedeAtacar(Jugador jugador) {
        HashMap<String, ArrayList<Pais>> paises = new HashMap<>();
        for (TarjetaPais tarjeta: tarjetasDePais.values()){
            Pais unPais = tarjeta.obtenerPais();
            if(unPais.obtenerFicha() == jugador.obtenerFicha() && unPais.cantidadDeEjercitos() > 1){
                paises.put(unPais.obtenerNombre(), new ArrayList());
                for(Pais pais: unPais.obtenerLimitrofes()){
                    if(pais.obtenerFicha() != unPais.obtenerFicha()){
                        paises.get(unPais.obtenerNombre()).add(pais);
                    }
                }
            }
        }
        return paises;
    }

}