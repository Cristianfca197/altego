package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void test01CrearUnTableroEsCorrecto(){
        Tablero unTablero = new Tablero();
        assertNotNull(unTablero);
    }

    @Test
    public void test02CrearUnContinenteLoGuardaCorrectamente(){
        Tablero unTablero = new Tablero();
        unTablero.crearContinente("America");
        assertTrue(unTablero.existeContinente("America"));
    }

    @Test
    public void test03ExisteContinenteEsFalsoSiNoEstaGuardado(){
        Tablero unTablero = new Tablero();
        assertFalse(unTablero.existeContinente("America"));
    }

    @Test
    public void test04ObtenerUnContinenteDevuelveElContinenteCorrecto(){
        Tablero unTablero = new Tablero();
        unTablero.crearContinente("America");
        assertEquals("America", unTablero.obtenerContinente("America").obtenerNombre());
    }

    @Test
    public void test05ObtenerUnContinenteDevuelveNullSiNoExisteElContinente(){
        Tablero unTablero = new Tablero();
        assertNull(unTablero.obtenerContinente("America"));
    }

    @Test
    public void test06CantidadDePaisesJugadorEsCorrecta(){
        Juego juego = new Juego(2);
        Jugador jugador = juego.obtenerJugador(1);

        juego.repartirPaises();
        juego.ocuparTablero();
        int cantidadPaises = juego.obtenerTablero().obtenerPaisesJugador(jugador);
        assertEquals(25, cantidadPaises);

    }
}
