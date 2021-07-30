package edu.fiuba.algo3.modelo.objetivo;

import java.util.ArrayList;

public interface Objetivo {

    abstract Boolean estaCumplido();

    abstract String obtenerTipo();

    abstract Integer paisesAConquistar(String unContinente);

    abstract ArrayList<String> continentesAOcupar();

    abstract String equipoADestruir();

    abstract String titulo();
}