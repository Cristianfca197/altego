package edu.fiuba.algo3.modelo.continente;

import java.util.*;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public abstract class Continente {
    private final String nombre;
    private final HashMap<String, Pais> paises = new HashMap<>();

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
            if(!pais.perteneceA(unJugador)){
                return 0;
            }
        }
        return this.cantidadEjercitosExtra();
    }
}
