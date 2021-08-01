package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.exception.ExcepcionCantidadInvalida;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaRColocacion extends EtapaRReagruparA {

    public EtapaRColocacion(Juego juego){
        super(juego);
    }

    public EtapaR pasarEtapa(){
        return new EtapaRAtacar(this.juego);
    }
}
