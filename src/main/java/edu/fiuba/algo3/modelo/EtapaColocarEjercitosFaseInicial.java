package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EtapaColocarEjercitosFaseInicial implements EtapasJuego {

    public EtapaColocarEjercitosFaseInicial() {
    }

    @Override
    public void iniciarEtapa(ArrayList<Jugador> listaJugadores, Jugador jugadorActual, Tablero tablero) {
        ArrayList<Pais> listaPaises = tablero.obtenerPaises();
        for (Jugador jugador: listaJugadores) {
            jugador.escogerUnPais(listaPaises).colocarEjercitos(5, jugador.obtenerFicha());
            jugador.escogerUnPais(listaPaises).colocarEjercitos(3, jugador.obtenerFicha());
        }
    }

    @Override
    public EtapasJuego nuevaEtapa() {
        return null;
    }
}
