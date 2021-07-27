package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public interface EtapaR {
     void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad);

     EtapaR pasarEtapa();

     void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor);

     void tranferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos);
}
