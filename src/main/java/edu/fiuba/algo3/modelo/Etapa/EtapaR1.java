package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaR1 implements EtapaR{

    private final int cantidadEjercitos;
    private final Juego juego;
    private int ejercitosColocados;

    public EtapaR1(Juego juego){
        this.juego = juego;
        this.cantidadEjercitos = 5;
        this.ejercitosColocados = 0;
    }


    @Override
    public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {
        if((ejercitosColocados + cantidad ) <= cantidadEjercitos) {
            jugadorActual.colocarEjercitosEn(cantidad, pais);
            ejercitosColocados += cantidad;
        }
    }

    @Override
    public EtapaR pasarEtapa() {
        return new EtapaR2(this.juego);
    }

    @Override
    public void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor) {

    }

    @Override
    public void transferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos) {

    }

    @Override
    public boolean estaTerminada() {
        if(this.ejercitosColocados == this.cantidadEjercitos){
            ejercitosColocados = 0;
            return true;
        }
        return false;
    }

    @Override
    public void establecerCantidadEjercitos(int cantidadEjercitos) {
    }

    @Override
    public int obtenerCantidadEjercitos() {
        return cantidadEjercitos - ejercitosColocados;
    }
}
