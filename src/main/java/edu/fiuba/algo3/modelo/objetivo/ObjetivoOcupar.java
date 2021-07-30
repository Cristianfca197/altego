package edu.fiuba.algo3.modelo.objetivo;

import java.util.ArrayList;
import java.util.HashMap;

public class ObjetivoOcupar implements Objetivo {

    private String titulo;
    private HashMap<String, Integer> continentesYCantidades;
    private ArrayList<String> continentesAOcupar;
    private int objetivoComunCantidad;
 
    public ObjetivoOcupar(String titulo, ArrayList<String> continentesAOcupar, HashMap<String, Integer> continentesYCantidades) {
        this.titulo = titulo;
        this.continentesYCantidades = continentesYCantidades;
        this.continentesAOcupar = continentesAOcupar;
    }

    @Override
    public Integer paisesAConquistar(String continente){
        return continentesYCantidades.get(continente);
    }

    @Override
    public Boolean estaCumplido() {
        return true;
    }

    @Override
    public String obtenerTipo() {
        return "Ocupar";
    }

    @Override
    public ArrayList<String> continentesAOcupar() {
        return this.continentesAOcupar;
    }

    @Override
    public String equipoADestruir() {
        return null;
    }

    @Override
    public String titulo() {
        return this.titulo();
    }

    @Override
    public void establecerObjetivoComun(int cantidad) {
        this.objetivoComunCantidad = cantidad;
    }

    @Override
    public int cantidadObjetivoComun() {
        return this.objetivoComunCantidad;
    }
    
}
