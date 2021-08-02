package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;

public class EtapaColocacion extends EtapaColocacionAbs {

    public EtapaColocacion(Juego juego){
        super(juego);
    }

    public Etapa pasarEtapa(){
        this.cantidadEjercitos = 0;
        return new EtapaAtacar(this.juego);
    }

    public void establecerCantidadEjercitos(int cantidadEjercitosDisponibles) {
            this.cantidadEjercitos = cantidadEjercitosDisponibles;
    }
}
