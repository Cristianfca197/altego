package edu.fiuba.algo3.modelo;

import java.util.*;

public class Juego { 
  
    private HashSet<TarjetaPais> tarjetasDePais;
    private HashMap<String, Pais> paises;
    private ArrayList<Jugador> listaJugadores;
    private LecturaArchivoTarjetas cargarTarjetas = new LecturaArchivoTarjetas();
    private LecturaArchivoPaises cargarPaises = new LecturaArchivoPaises();

    public Juego(int cantidadJugadores) {
        listaJugadores = new ArrayList<>();
        for (int i = 0; i < cantidadJugadores; i++) {
            this.listaJugadores.add(new Jugador());
        }
        if (cargarTarjetas.leerArchivos()){ this.tarjetasDePais = cargarTarjetas.getTarjetas(); }
        if(cargarPaises.leerArchivo()){ this.paises = cargarPaises.getPaises(); }
    }
    public void entregarTarjetas(){
        for (TarjetaPais tarjetaPais: this.tarjetasDePais){
            System.out.println(tarjetaPais.obtenerTipo());
            System.out.println(tarjetaPais.obtenerPais().obtenerNombre());
        }
    }
    public void entregarPaises(){
        for (Pais unPais: this.paises.values()){
            System.out.println(unPais.obtenerNombre());
            System.out.println(unPais.continenteNombre());
            for (String i: unPais.listaPaisesLimitrofes()){
                System.out.println(i);
            }
        }
    }


    public Integer cantidadDeJugadores() {
        return this.listaJugadores.size();
    }
}