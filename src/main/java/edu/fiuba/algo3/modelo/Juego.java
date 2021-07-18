package edu.fiuba.algo3.modelo;

import java.util.*;

public class Juego { 
  
    private HashMap<String, TarjetaPais> tarjetasDePais;
    private ArrayList<Jugador> listaJugadores;
    private LecturaArchivoTarjetas cargarTarjetas = new LecturaArchivoTarjetas();
    private LecturaArchivoPaises cargarPaises = new LecturaArchivoPaises();

    public Juego(int cantidadJugadores) {
        listaJugadores = new ArrayList<>();
        for (int i = 0; i < cantidadJugadores; i++) {
            this.listaJugadores.add(new Jugador());
        }
        if (cargarTarjetas.leerArchivos()){ this.tarjetasDePais = cargarTarjetas.getTarjetas(); }
        cargarPaises.leerArchivo(this.tarjetasDePais);
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
            for (TarjetaPais i: tarjetasDePais.values()){
                System.out.println(tarjetaPais.obtenerPais().obtenerNombreLimitrofes());
            }
        }
    }


    public Integer cantidadDeJugadores() {
        return this.listaJugadores.size();
    }
}