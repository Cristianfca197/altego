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

    @Test
    public void test08RondaDeColocacionDeEjercitos2JugadoresUnoRealizaMultiplesCanjes()throws ExcepcionCanjeInvalido{
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        int cantidadEjercitos = 0;
        ArrayList<TarjetaPais> tarjetas = new ArrayList<TarjetaPais>();

        Jugador jugador1 = juego.obtenerJugador(1);
        Jugador jugador2 = juego.obtenerJugador(2);

        TarjetaPais tarjeta1 = juego.obtenerTarjeta("Iran");
        TarjetaPais tarjeta2 = juego.obtenerTarjeta("Francia");
        TarjetaPais tarjeta3 = juego.obtenerTarjeta("Chile");

        tarjetas.add(tarjeta1);
        tarjetas.add(tarjeta2);
        tarjetas.add(tarjeta3);

        cantidadEjercitos = jugador1.canjearTarjetas(tarjetas);
        assertEquals(4, cantidadEjercitos);

        cantidadEjercitos = jugador1.canjearTarjetas(tarjetas);
        assertEquals(7, cantidadEjercitos);

    }
    @Test
    public void test09RondaDeColocacionDeEjercitos2Jugadores()throws ExcepcionCanjeInvalido{
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        int cantidadEjercitos = 0;
        ArrayList<TarjetaPais> tarjetas = new ArrayList<TarjetaPais>();

        Jugador jugador1 = juego.obtenerJugador(1);
        Jugador jugador2 = juego.obtenerJugador(2);

        TarjetaPais tarjeta1 = juego.obtenerTarjeta("Iran");
        TarjetaPais tarjeta2 = juego.obtenerTarjeta("Francia");
        TarjetaPais tarjeta3 = juego.obtenerTarjeta("Chile");

        tarjetas.add(tarjeta1);
        tarjetas.add(tarjeta2);
        tarjetas.add(tarjeta3);

        cantidadEjercitos = jugador1.canjearTarjetas(tarjetas);
        assertEquals(4, cantidadEjercitos);

        cantidadEjercitos += juego.obtenerEjercitos(jugador1);
        assertEquals(16, cantidadEjercitos);

        cantidadEjercitos = jugador2.canjearTarjetas(tarjetas);
        cantidadEjercitos += juego.obtenerEjercitos(jugador2);
        cantidadEjercitos += jugador2.realizarCanje(tarjetas);

        assertEquals(23, cantidadEjercitos);

    }
    @Test
    public void test10RondaDeColocacionDeEjercitos2JugadoresUnoTieneOceania()throws ExcepcionCanjeInvalido {
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        int cantidadEjercitos = 0;

        Jugador jugador1 = juego.obtenerJugador(1);
        Jugador jugador2 = juego.obtenerJugador(2);
        Pais unPais = juego.obtenerTablero().obtenerPais("Java");
        unPais.asignarJugador(jugador2);


        cantidadEjercitos += juego.obtenerEjercitos(jugador1);
        assertEquals(12, cantidadEjercitos);

        cantidadEjercitos = juego.obtenerEjercitos(jugador2);

        assertEquals(15, cantidadEjercitos);

    }
    @Test
    public void test11RondaDeAtaqueConDosJugadoresJugador1AtacaYConquistaDosPaisesEnemigos(){
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();

        Jugador jugador1 = juego.obtenerJugador(1);
        Jugador jugador2 = juego.obtenerJugador(2);

        Pais argentina = juego.obtenerTablero().obtenerPais("Argentina");
        Pais chile = juego.obtenerTablero().obtenerPais("Chile");
        Pais brasil = juego.obtenerTablero().obtenerPais("Brasil");

        argentina.asignarJugador(jugador1);
        chile.asignarJugador(jugador2);
        brasil.asignarJugador(jugador2);

        argentina.colocarEjercitos(20, jugador1.obtenerFicha());

        ArrayList<Pais> paisesEnemigos = new ArrayList<>();
        paisesEnemigos.add(chile);
        paisesEnemigos.add(brasil);

        while (chile.obtenerFicha() != jugador1.obtenerFicha()){ 
            jugador1.hacerAtaques(argentina, paisesEnemigos); 
        }
        paisesEnemigos.remove(0);
        argentina.colocarEjercitos(20,jugador1.obtenerFicha());
        while (brasil.obtenerFicha() != jugador1.obtenerFicha()){ 
            jugador1.hacerAtaques(argentina, paisesEnemigos);
        }

    }
}
