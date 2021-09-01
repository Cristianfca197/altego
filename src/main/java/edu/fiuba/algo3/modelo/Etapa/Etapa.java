package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

public interface Etapa {

     void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad);

     Etapa pasarEtapa();

     void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor);

     void transferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos);

     boolean estaTerminada();

     void establecerCantidadEjercitos(int cantidadEjercitos);

     int obtenerCantidadEjercitos();

     void agregarEjercitosCanje(int cantidadEjercitos);
}
