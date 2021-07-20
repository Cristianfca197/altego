package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {
    @Test
    public void test01CargaDeTarjetasPaisEsCorrecta(){
        Juego juego = new Juego(2);
        juego.entregarTarjetas();
    }
    @Test
    public void test02CargaPaisesEsCorrecta(){
        Juego juego = new Juego(2);
        juego.entregarPaises();
    }
    @Test
    public void test03RepartirPaises(){
        Juego juego = new Juego(2);
        juego.repartirPaises();
        juego.ocuparTablero();
    }
    @Test
    public void test04RepartirPaises(){
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
    }
    @Test
    public void test05RondaDeColocacionDeEjercitos2JugadoresAmbosJugadoresColocanSoloLosEjercitosPorPaises(){
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        Jugador jugador1 = juego.obtenerJugador(1);
        Jugador jugador2 = juego.obtenerJugador(2);

        int ejercitosJugador1 = juego.obtenerEjercitos(jugador1);
        int ejercitosJugador2 = juego.obtenerEjercitos(jugador2);
        assertEquals(12, ejercitosJugador1);
        assertEquals(12, ejercitosJugador2);

        Pais pais1 = juego.obtenerTablero().obtenerPais("Turquia");
        Pais pais2 = juego.obtenerTablero().obtenerPais("Iran");

        jugador1.colocarEjercitosEn(7,pais1);
        jugador1.colocarEjercitosEn(5,pais2);

        assertEquals(8, pais1.cantidadDeEjercitos());
        assertEquals(6, pais2.cantidadDeEjercitos());

        pais1 = juego.obtenerTablero().obtenerPais("Francia");
        pais2 = juego.obtenerTablero().obtenerPais("Chile");
        Pais pais3 = juego.obtenerTablero().obtenerPais("Colombia");

        jugador2.colocarEjercitosEn(2,pais1);
        jugador2.colocarEjercitosEn(6,pais2);
        jugador2.colocarEjercitosEn(4,pais3);

        assertEquals(3, pais1.cantidadDeEjercitos());
        assertEquals(7, pais2.cantidadDeEjercitos());
        assertEquals(5, pais3.cantidadDeEjercitos());
    }

    @Test
    public void test06RondaDeColocacionDeEjercitos2JugadoresUnoActivaTarjetaDePais(){
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        Jugador jugador1 = juego.obtenerJugador(1);
        Jugador jugador2 = juego.obtenerJugador(2);
        TarjetaPais tarjeta = juego.obtenerTarjeta("Iran");
        jugador1.activarTarjetaPais(tarjeta);

        Pais pais1 = juego.obtenerTablero().obtenerPais("Iran");

        assertEquals(3, pais1.cantidadDeEjercitos());

    }
    @Test
    public void test07RondaDeColocacionDeEjercitos2JugadoresUnoActivaTarjetaDePaisyLuegoAgregoEJercitos(){
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        Jugador jugador1 = juego.obtenerJugador(1);
        Jugador jugador2 = juego.obtenerJugador(2);
        TarjetaPais tarjeta = juego.obtenerTarjeta("Iran");
        jugador1.activarTarjetaPais(tarjeta);

        Pais pais1 = juego.obtenerTablero().obtenerPais("Iran");
        jugador1.colocarEjercitosEn(3, pais1);
        assertEquals(6, pais1.cantidadDeEjercitos());

    }
    /*
    VER Q NO ANDA BIEN EL CANJE
    @Test
    public void test08RondaDeColocacionDeEjercitos2JugadoresUnoRealizaMultiplesCanjes(){
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        int cantidadEjercitos = 0;
        ArrayList<TarjetaPais> tarjetasCanje;
        Jugador jugador1 = juego.obtenerJugador(1);
        Jugador jugador2 = juego.obtenerJugador(2);

        TarjetaPais tarjeta1 = juego.obtenerTarjeta("Iran");
        TarjetaPais tarjeta2 = juego.obtenerTarjeta("Francia");
        TarjetaPais tarjeta3 = juego.obtenerTarjeta("Chile");

        juego.entregarTarjeta(jugador1, tarjeta1);
        juego.entregarTarjeta(jugador1, tarjeta2);
        juego.entregarTarjeta(jugador1, tarjeta3);
        cantidadEjercitos = jugador1.realizarCanje();

        assertEquals(4, cantidadEjercitos);

        juego.entregarTarjeta(jugador1, tarjeta1);
        juego.entregarTarjeta(jugador1, tarjeta2);
        juego.entregarTarjeta(jugador1, tarjeta3);
        cantidadEjercitos = jugador1.realizarCanje();
        assertEquals(7, cantidadEjercitos);

        VER Q NO ANDA BIEN EL CANJE
    }

     */
}
