package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EtapaAtacar implements EtapasJuego {
    public EtapaAtacar(){

    }
    @Override
    public void iniciarEtapa(ArrayList<Jugador> listaJugadores, Tablero tablero) {
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
