package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.exception.ExcepcionCantidadInvalida;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaR2 extends EtapaRReagruparA{

    public EtapaR2(Juego juego){
        super(juego);
        this.cantidadEjercitos = 3;
        this.ejercitosColocados = 0;
    }

    public EtapaR pasarEtapa() {
        return new EtapaRAtacar(this.juego);
    }

}
