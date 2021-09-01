package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;

public class EtapaColocacionRondaUno extends EtapaColocacionAbs {

    public EtapaColocacionRondaUno(Juego juego){
        super(juego);
        this.cantidadEjercitos = 5;
        this.ejercitosColocados = 0;
    }
    @Override
    public Etapa pasarEtapa() { return new EtapaColocacionRondaDos(this.juego); }

    public void establecerCantidadEjercitos(int cantidadEjercitosDisponibles) {
    }

}
