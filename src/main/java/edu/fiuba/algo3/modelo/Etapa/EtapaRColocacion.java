package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;

public class EtapaRColocacion extends EtapaRReagruparA {

    public EtapaRColocacion(Juego juego){
        super(juego);
        this.cantidadEjercitos = 0;
    }

    public EtapaR pasarEtapa(){
        return new EtapaRAtacar(this.juego);
    }
}
