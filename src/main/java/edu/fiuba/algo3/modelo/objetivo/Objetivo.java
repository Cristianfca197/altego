package edu.fiuba.algo3.modelo.objetivo;

public interface Objetivo {

     abstract Boolean estaCumplido();

     abstract String obtenerTipo();

    abstract Integer paisesAConquistar(String string);


}