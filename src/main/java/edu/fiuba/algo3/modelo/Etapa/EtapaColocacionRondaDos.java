package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;

public class EtapaColocacionRondaDos extends EtapaColocacionAbs {

    public EtapaColocacionRondaDos(Juego juego){
        super(juego);
        this.cantidadEjercitos = 3;
        this.ejercitosColocados = 0;
    }

    public Etapa pasarEtapa() {
        return new EtapaAtacar(this.juego);
    }

    public void establecerCantidadEjercitos(int cantidadEjercitosDisponibles) {
    }
}
