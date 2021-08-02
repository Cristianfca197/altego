package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.controlador.Alerta;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaRAtacar implements EtapaR {

    private final Juego juego;

    public EtapaRAtacar(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {

    }

    public EtapaR pasarEtapa(){
        this.juego.terminarAtaques();
        return new EtapaRReagrupar(this.juego);
    }

    @Override
    public void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor) {
        if(jugadorActual.obtenerFicha() == atacante.obtenerFicha()) {
            try {
                atacante.atacarA(defensor);
            } catch (Exception e){
                new Alerta(e.getMessage(), "Ataque inválido");
            }
        }else{
            new Alerta("Pais Atacante no es un pais propio.", atacante.obtenerNombre());
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
