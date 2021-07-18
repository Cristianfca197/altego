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


    public Integer cantidadDeJugadores() {
        return this.listaJugadores.size();
    }
}