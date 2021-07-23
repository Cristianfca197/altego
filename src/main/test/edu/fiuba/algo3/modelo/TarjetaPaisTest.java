package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.tipoTarjeta.Canion;

import static org.junit.jupiter.api.Assertions.*;

public class TarjetaPaisTest {
    
    @Test
    public void test01CreoTarjetaYTipoEsElCorrecto(){
        TarjetaPais unaTarjeta = new TarjetaPais(new Canion(), "Argentina");

        assertTrue(unaTarjeta.obtenerTipo().esCanion());
    }

    @Test
    public void test02CreoTarjetoYPaisEsElCorrecto(){
        TarjetaPais unaTarjeta = new TarjetaPais(new Canion(), "Argentina");

        assertEquals("Argentina", unaTarjeta.obtenerPais().obtenerNombre());
    }
    @Test
    public void test03TarjetaDePaisEnPosesionDelJugadorPossedorDelPais(){
        TarjetaPais unaTarjeta = new TarjetaPais(new Canion(), "Argentina");
        Jugador jugador = new Jugador();
        unaTarjeta.obtenerPais().asignarJugador(jugador);

        assertTrue(unaTarjeta.paisEsDe(jugador));
    }
}
