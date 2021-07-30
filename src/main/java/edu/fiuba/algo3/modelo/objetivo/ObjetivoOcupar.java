package edu.fiuba.algo3.modelo.objetivo;

import java.util.HashMap;

public class ObjetivoOcupar implements Objetivo {

    private String titulo;
    private HashMap<String, Integer> continentesYCantidades;
 
    public ObjetivoOcupar(String titulo, HashMap<String, Integer> continentesYCantidades) {
        this.titulo = titulo;
        this.continentesYCantidades = continentesYCantidades;
    }

    @Override
    public Integer paisesAConquistar(String pais){
        return continentesYCantidades.get(pais);
    }

    @Override
    public Boolean estaCumplido() {
        return true;
    }

    @Override
    public String obtenerTipo() {
        return "Ocupar";
    }
    
}
