package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

interface EtapasJuego {
    void iniciarEtapa(ArrayList<Jugador> listaJugadores, Jugador jugadorActual, Tablero tablero);
    EtapasJuego nuevaEtapa();

}
