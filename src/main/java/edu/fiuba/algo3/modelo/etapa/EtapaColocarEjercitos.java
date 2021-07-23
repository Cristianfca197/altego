package edu.fiuba.algo3.modelo.etapa;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Tablero;

public class EtapaColocarEjercitos implements EtapasJuego {
    public EtapaColocarEjercitos(){

    }
    @Override
    public void iniciarEtapa(ArrayList<Jugador> listaJugadores, Jugador jugadorActual, Tablero tablero) {
        for(Jugador jugador: listaJugadores){//agrega los ejercitos en el primer pais de cada jugador
            int cantidadFichasNuevas = tablero.obtenerCantidadPaisesJugador(jugador) / 2;
            cantidadFichasNuevas += tablero.fichasContinente(jugador);
            jugador.colocarEjercitosEn(cantidadFichasNuevas, jugador.escogerUnPais(tablero.obtenerPaises()));
        }
    }

    @Override
    public EtapasJuego nuevaEtapa() {
        return new EtapaAtacar();
    }
}
