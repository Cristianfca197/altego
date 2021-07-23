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
        ArrayList<Pais> paises = tablero.obtenerPaises();
        for (Jugador jugador: listaJugadores){
            boolean pasarTurno = false;
            while(!pasarTurno) {
                Pais atacante = jugador.escogerUnPais(paises);
                Pais defensor = jugador.escogerUnPaisEnemigo(atacante.obtenerLimitrofes());
                atacante.atacarA(defensor);
                pasarTurno = jugador.pasarTurno();
            }
        }
    }

    @Override
    public EtapasJuego nuevaEtapa() {
        return new EtapaReagrupar();
    }
}
