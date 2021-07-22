package edu.fiuba.algo3.modelo;

import java.util.*;

public abstract class Continente {
    private String nombre;
    private HashMap<String, Pais> paises = new HashMap<>();

    public Continente(String unNombre){
        this.nombre = unNombre;
    }

    public void aniadirPais(Pais unPais){
        if (!this.paises.containsKey(unPais.obtenerNombre()))
            this.paises.put(unPais.obtenerNombre(), unPais);
    }


    public String obtenerNombre(){
        return this.nombre;
    }

    public Collection<Pais>obtenerPaises() {
        return paises.values();
    }

    public Pais obtenerPais(String unPais) { return paises.get(unPais);
    }
    abstract int cantidadEjercitosExtra();


    public int obtenerEjercitosExtra(Jugador unJugador){
        for(Pais pais : this.obtenerPaises()){
            if(!(pais.obtenerFicha().esIgualA((unJugador.obtenerFicha())))){
                return 0;
            }
        }
        return this.cantidadEjercitosExtra();
    }
}
