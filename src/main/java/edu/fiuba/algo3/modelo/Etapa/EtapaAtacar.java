package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.exception.ExcepcionPaisInvalido;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaAtacar implements Etapa {

    private final Juego juego;

    public EtapaAtacar(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {

    }

    public Etapa pasarEtapa(){
        this.juego.terminarAtaques();
        return new EtapaReagrupar(this.juego);
    }

    @Override
    public void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor) {
        if(jugadorActual.obtenerFicha() == atacante.obtenerFicha()) {
            atacante.atacarA(defensor);
        }else{
            throw new ExcepcionPaisInvalido(atacante.obtenerNombre() + " no es un pais propio.");
        }
    }

    @Override
    public void transferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos) {

    }

    @Override
    public boolean estaTerminada() {
        return true;
    }

    @Override
    public void establecerCantidadEjercitos(int cantidadEjercitos) {

    }

    @Override
    public int obtenerCantidadEjercitos() {
        return 0;
    }

    @Override
    public void agregarEjercitosCanje(int cantidadEjercitos) {

    }
}
