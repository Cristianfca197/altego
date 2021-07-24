package edu.fiuba.algo3.modelo.etapa;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;

public class EtapaAtacar implements EtapasJuego {
    public EtapaAtacar(){

    }

    @Override
    public void iniciarEtapa(ArrayList<Jugador> listaJugadores, Jugador jugadorActual, Tablero tablero) {
    }

    @Override
    public EtapasJuego nuevaEtapa() {
        return new EtapaReagrupar();
    }
}
