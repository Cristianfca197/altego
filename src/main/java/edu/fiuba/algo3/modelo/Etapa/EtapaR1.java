package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.exception.ExcepcionCantidadInvalida;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaR1 extends EtapaRReagruparA{

    public EtapaR1(Juego juego){
        super(juego);
        this.cantidadEjercitos = 5;
        this.ejercitosColocados = 0;
    }
    @Override
    public EtapaR pasarEtapa() { return new EtapaR2(this.juego); }

}
