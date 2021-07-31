package edu.fiuba.algo3.modelo.objetivo;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.juego.Ficha;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;

public interface Objetivo {

    abstract Boolean estaCumplido();

    abstract void establecerObjetivoComun(int cantidad);

    abstract int cantidadObjetivoComun();

    abstract String obtenerTipo();

    abstract Integer paisesAConquistar(String unContinente);

    abstract ArrayList<String> continentesAOcupar();

    abstract String equipoADestruir();

    abstract String titulo();

    abstract void equipoDestruido(String string);

    abstract void paisesConquistados(Tablero tablero, Jugador unJugador);
}