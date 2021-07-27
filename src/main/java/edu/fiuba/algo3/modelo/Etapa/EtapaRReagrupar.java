package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaRReagrupar implements EtapaR {

    @Override
    public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {

    }

    public EtapaR pasarEtapa(){
        return new EtapaRinicial();
    }

    @Override
    public void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor) {

    }

    @Override
    public void transferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos) {
        if(aliado1.perteneceA(jugadorActual) && aliado2.perteneceA(jugadorActual)) {
            for (int i = 0; i < cantidadEjercitos; i++) {
                aliado2.colocarEjercitos(i, jugadorActual.obtenerFicha());
                aliado1.eliminarEjercito();
            }
        }
    }
}
