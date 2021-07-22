package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EtapaReagrupar implements EtapasJuego {
    @Override
    public void iniciarEtapa(ArrayList<Jugador> listaJugadores, Tablero tablero) {

    }

    @Override
    public EtapasJuego nuevaEtapa() {
        return new EtapaColocarEjercitos();
    }
}
