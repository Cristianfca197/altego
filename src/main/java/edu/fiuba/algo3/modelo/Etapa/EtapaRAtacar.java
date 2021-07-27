package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaRAtacar implements EtapaR {

    @Override
    public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {

    }

    public EtapaR pasarEtapa(){
        return new EtapaRReagrupar();
    }

    @Override
    public void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor) {
        if(jugadorActual.obtenerFicha() == atacante.obtenerFicha()) {
            atacante.atacarA(defensor);
        }
    }

    @Override
    public void transferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos) {

    }
}
