package edu.fiuba.algo3.modelo;

import java.util.*;

public class Juego { 
  
    private HashSet<TarjetaPais> tarjetasDePais;
    private ArrayList<Jugador> listaJugadores;
    private LecturaArchivoTarjetas cargarTarjetas = new LecturaArchivoTarjetas();

    public Juego(int cantidadJugadores) {
        listaJugadores = new ArrayList<>();
        for (int i = 0; i < cantidadJugadores; i++) {
            this.listaJugadores.add(new Jugador());
        }
        this.tarjetasDePais = cargarTarjetas.leerArchivos();
    }
    public void entregarTarjetas(){
        for (TarjetaPais i: this.tarjetasDePais){
            System.out.println(i.obtenerTipo());
            System.out.println(i.obtenerPais().obtenerNombre());
        }
    }


    public Integer cantidadDeJugadores() {
        return this.listaJugadores.size();
    }
}