package edu.fiuba.algo3.modelo.objetivo;

import java.util.ArrayList;

public class ObjetivoComun implements Objetivo{

    private Integer cantidadPaises;

    public ObjetivoComun(String titulo, Integer cantidad) {

        this.cantidadPaises = cantidad;
    }

    @Override
    public Boolean estaCumplido() {
        return null;
    }

    @Override
    public String obtenerTipo() {
        return "Comun";
    }

    @Override
    public Integer paisesAConquistar(String string) {
        return this.cantidadPaises;
    }

    @Override
    public ArrayList<String> continentesAOcupar() {
        return null;
    }

    @Override
    public String equipoADestruir() {
        return null;
    }

    @Override
    public String titulo() {
        return this.titulo();
    }
    
}
