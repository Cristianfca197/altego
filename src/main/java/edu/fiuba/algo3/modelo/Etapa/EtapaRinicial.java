package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public class EtapaRinicial implements EtapaR {

    @Override
    public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {
        jugadorActual.colocarEjercitosEn(cantidad, pais);
    }

    public EtapaR pasarEtapa(){
        return new EtapaRAtacar();
    }

    @Override
    public void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor) {

    }

    @Override
    public void transferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos) {

    }
}
