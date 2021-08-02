package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;

public class EtapaRColocacion extends EtapaRReagruparA {

    public EtapaRColocacion(Juego juego){
        super(juego);
    }

    public EtapaR pasarEtapa(){
        this.cantidadEjercitos = 0;
        return new EtapaRAtacar(this.juego);
    }

    public void establecerCantidadEjercitos(int cantidadEjercitosDisponibles) {
            this.cantidadEjercitos = cantidadEjercitosDisponibles;
    }
}
