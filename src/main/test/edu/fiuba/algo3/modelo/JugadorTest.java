package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void test01CreoDosJugadoresYTienenFichasDistintas(){
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
    
        assertNotEquals(unJugador.obtenerFicha(), otroJugador.obtenerFicha());
        assertFalse(unJugador.obtenerFicha().esIgualA(otroJugador.obtenerFicha()));
    }
}
