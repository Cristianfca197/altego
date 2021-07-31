package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaRColocacion implements EtapaR {
    private final Juego juego;
    private int ejercitosColocados;
    private int cantidadEjercitos;

    public EtapaRColocacion(Juego juego){
        this.juego = juego;
    }
    @Override
    public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {
        if((ejercitosColocados + cantidad ) <= cantidadEjercitos) {
            jugadorActual.colocarEjercitosEn(cantidad, pais);
            ejercitosColocados += cantidad;
        }
    }

    public EtapaR pasarEtapa(){
        return new EtapaRAtacar(this.juego);
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
    public void establecerCantidadEjercitos(int cantidadEjercitosDisponibles) {
        this.cantidadEjercitos = cantidadEjercitosDisponibles;
    }

    @Override
    public int obtenerCantidadEjercitos() {
        return cantidadEjercitos - ejercitosColocados;
    }
}
