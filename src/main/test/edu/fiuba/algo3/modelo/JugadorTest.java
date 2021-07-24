package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.exception.ExcepcionActivacionTarjetaInvalido;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.tipoTarjeta.Canion;

import java.util.ArrayList;

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
    @Test
    public void test05JugadorHacePrimerCanjeYRecibeCuatroEjercitos(){
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        assertEquals(4,unJugador.canjearTarjetas(unJugador.obtenerTarjetas()));
    }
    @Test
    public void test06JugadorHaceSegundoCanjeYRecibeSieteEjercitos(){
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        assertEquals(7,unJugador.canjearTarjetas(unJugador.obtenerTarjetas()));
    }
    @Test
    public void test07JugadorHaceTresOMasCanjesYRecibeDiezEjercitos(){
        Jugador unJugador = new Jugador();

        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        assertEquals(10,unJugador.canjearTarjetas(unJugador.obtenerTarjetas()));
    }
    @Test
    public void test08JugadorHaceCuartoCanjeYRecibeQuinceEjercitos(){
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        assertEquals(15,unJugador.canjearTarjetas(unJugador.obtenerTarjetas()));
    }
    @Test
    public void test09JugadorHaceQuintoCanjeYRecibeVeinteEjercitos(){
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.canjearTarjetas(unJugador.obtenerTarjetas());
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        assertEquals(20,unJugador.canjearTarjetas(unJugador.obtenerTarjetas()));
    }
    @Test
    public void test10JugadorHacePrimerCanjeYColocaLosNuevosEjercitosCorrectamente(){
        Jugador unJugador = new Jugador();
        Pais unPais = new Pais("Argentina");

        unPais.asignarJugador(unJugador);
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.agregarTarjeta(tarjetaPais1);
        unJugador.agregarTarjeta(tarjetaPais2);
        unJugador.agregarTarjeta(tarjetaPais3);
        unJugador.colocarEjercitosCanje(unJugador.canjearTarjetas(unJugador.obtenerTarjetas()), unPais);
        assertEquals(5, unPais.cantidadDeEjercitos());
    }
}
