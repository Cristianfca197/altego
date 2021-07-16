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

    @Test
    public void test02ActivarTarjetaPaisCorrectamente()throws ExcepcionActivacionTarjetaInvalido{
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais = new TarjetaPais(new Canion(), "Brasil");

        tarjetaPais.obtenerPais().asignarJugador(unJugador);
        tarjetaPais.activarTarjeta(unJugador);

        assertEquals(3,tarjetaPais.obtenerPais().cantidadDeEjercitos());
    }
    @Test
    public void test03ActivarTarjetaDePaisQueNoSePosee(){
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
        TarjetaPais tarjetaPais = new TarjetaPais(new Canion(), "Brasil");

        tarjetaPais.obtenerPais().asignarJugador(otroJugador);

        assertThrows(ExcepcionActivacionTarjetaInvalido.class, () -> {tarjetaPais.activarTarjeta(unJugador);});
    }

    @Test
    public void test04ActivarTarjetaDePaisYaActivada()throws ExcepcionActivacionTarjetaInvalido{
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais = new TarjetaPais(new Canion(), "Brasil");

        tarjetaPais.obtenerPais().asignarJugador(unJugador);
        tarjetaPais.activarTarjeta(unJugador);

        assertThrows(ExcepcionActivacionTarjetaInvalido.class, () -> {tarjetaPais.activarTarjeta(unJugador);});
    }
}
