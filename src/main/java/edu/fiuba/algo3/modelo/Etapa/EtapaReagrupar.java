package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.exception.ExcepcionPaisInvalido;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaReagrupar implements Etapa {

    private final Juego juego;

    public EtapaReagrupar(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {

    }

    public Etapa pasarEtapa(){
        return new EtapaColocacion(this.juego);
    }

    @Override
    public void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor) {

    }

    @Override
    public void transferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos) {
        if(aliado1.perteneceA(jugadorActual) && aliado2.perteneceA(jugadorActual)) {
            aliado1.eliminarEjercitos(cantidadEjercitos);
            aliado2.colocarEjercitos(cantidadEjercitos, jugadorActual.obtenerFicha());
        }else{
            throw new ExcepcionPaisInvalido("Algún país no es propio");
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

    @Override
    public void agregarEjercitosCanje(int cantidadEjercitos) {

    }
}
