package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaRReagrupar implements EtapaR {


    private final Juego juego;

    public EtapaRReagrupar(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {

    }

    public EtapaR pasarEtapa(){
        return new EtapaRColocacion(this.juego);
    }

    @Override
    public void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor) {

    }

    @Override
    public void transferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos) {;
        if(aliado1.perteneceA(jugadorActual) && aliado2.perteneceA(jugadorActual)) {
            for (int i = 0; i < cantidadEjercitos; i++) {
                aliado2.colocarEjercitos(i, jugadorActual.obtenerFicha());
                aliado1.eliminarEjercito();
            }
        }
    }

    @Override
    public boolean estaTerminada() {
        return true;
    }

    @Override
    public void establecerCantidadEjercitos(int cantidadEjercitos) {}

    @Override
    public int obtenerCantidadEjercitos() {
        return 0;
    }
}
