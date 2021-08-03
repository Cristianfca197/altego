package edu.fiuba.algo3.modelo.objetivo;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Tablero;

public interface Objetivo {

     Boolean estaCumplido();

     void establecerObjetivoComun(int cantidad);

     int cantidadObjetivoComun();

     void actualizar(Juego juego);

     String obtenerTipo();

     Integer paisesAConquistar(String unContinente);

     ArrayList<String> continentesAOcupar();

     String equipoADestruir();

     String titulo();

     void equipoDestruido(String string, Juego juego);

     void paisesConquistados(Tablero tablero, Jugador unJugador);

     void asignarJugador(Jugador unJugador);
}