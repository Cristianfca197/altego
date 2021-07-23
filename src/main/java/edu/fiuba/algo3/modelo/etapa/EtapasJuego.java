package edu.fiuba.algo3.modelo.etapa;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Tablero;

public interface EtapasJuego {
    void iniciarEtapa(ArrayList<Jugador> listaJugadores, Jugador jugadorActual, Tablero tablero);
    EtapasJuego nuevaEtapa();

}
