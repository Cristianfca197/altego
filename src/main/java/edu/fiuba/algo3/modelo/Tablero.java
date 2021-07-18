package edu.fiuba.algo3.modelo;

import java.util.*;

public class Tablero {

    private HashMap<String, Continente> continentes = new HashMap<String, Continente>();

    public Tablero(){

    }
    
    public boolean existeContinente(String unContinente){
        return this.continentes.containsKey(unContinente);
    }

    public Continente obtenerContinente(String unContinente){
        return this.continentes.get(unContinente);
    }

    public void crearContinente(String unContinente){
        this.continentes.put(unContinente, new Continente(unContinente));
    }
    
}
