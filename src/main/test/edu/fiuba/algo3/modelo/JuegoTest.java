package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Etapa.*;
import edu.fiuba.algo3.modelo.exception.ExcepcionCanjeInvalido;
import edu.fiuba.algo3.modelo.exception.ExcepcionCantidadInvalida;
import edu.fiuba.algo3.modelo.exception.ExcepcionFinDeJuego;
import edu.fiuba.algo3.modelo.exception.ExcepcionPasarTurnoNoEsPosible;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {
    @Test
    public void test01CargaDeTarjetasPaisEsCorrecta(){
        Juego juego = new Juego(2);
        assertNotNull(juego.obtenerTarjetas());
    }
    @Test
    public void test02CargaPaisesEsCorrecta(){
        Juego juego = new Juego(2);
        assertNotNull(juego.obtenerPaises());
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
        ArrayList<TarjetaPais> tarjetas = new ArrayList<>();

        Jugador jugador1 = juego.obtenerJugador(1);

        TarjetaPais tarjeta1 = juego.obtenerTarjeta("Iran");
        TarjetaPais tarjeta2 = juego.obtenerTarjeta("Francia");
        TarjetaPais tarjeta3 = juego.obtenerTarjeta("Chile");

        tarjetas.add(tarjeta1);
        tarjetas.add(tarjeta2);
        tarjetas.add(tarjeta3);

        int cantidadEjercitos = jugador1.canjearTarjetas(tarjetas);
        assertEquals(4, cantidadEjercitos);

        cantidadEjercitos = jugador1.canjearTarjetas(tarjetas);
        assertEquals(7, cantidadEjercitos);

    }
    @Test
    public void test09RondaDeColocacionDeEjercitos2Jugadores()throws ExcepcionCanjeInvalido{
        Juego juego = new Juego(2);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        ArrayList<TarjetaPais> tarjetas = new ArrayList<>();

        Jugador jugador1 = juego.obtenerJugador(1);
        Jugador jugador2 = juego.obtenerJugador(2);

        TarjetaPais tarjeta1 = juego.obtenerTarjeta("Iran");
        TarjetaPais tarjeta2 = juego.obtenerTarjeta("Francia");
        TarjetaPais tarjeta3 = juego.obtenerTarjeta("Chile");

        tarjetas.add(tarjeta1);
        tarjetas.add(tarjeta2);
        tarjetas.add(tarjeta3);

        int cantidadEjercitos = jugador1.canjearTarjetas(tarjetas);
        assertEquals(4, cantidadEjercitos);

        cantidadEjercitos += juego.obtenerEjercitos(jugador1);
        assertEquals(16, cantidadEjercitos);

        cantidadEjercitos = jugador2.canjearTarjetas(tarjetas);
        cantidadEjercitos += juego.obtenerEjercitos(jugador2);
        cantidadEjercitos += jugador2.canjearTarjetas(tarjetas);

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
        Pais unPais = juego.obtenerTablero().obtenerPais("Sumatra");
        unPais.asignarJugador(jugador2);


        cantidadEjercitos += juego.obtenerEjercitos(jugador1);
        assertEquals(12, cantidadEjercitos);

        cantidadEjercitos = juego.obtenerEjercitos(jugador2);


        assertEquals(15, cantidadEjercitos);

    }

    @Test
    public void test11JuegoFaseInicialColocacionDeCincoEjercitos(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        assertEquals(6, pais1.cantidadDeEjercitos());
        assertEquals(6, pais2.cantidadDeEjercitos());
    }

    @Test
    public void test12JuegoPasarTurnoNoEsPosible(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        assertThrows(ExcepcionPasarTurnoNoEsPosible.class, ()->juego.pasarTurno());

    }

    @Test
    public void test13JuegoPasarTurnoCondicionesNecesariasPaseDeEtapa(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        Etapa etapaActual = juego.obtenerEtapaR();
        assertEquals( EtapaColocacionRondaDos.class, etapaActual.getClass());
    }

    @Test
    public void test14JuegoPasarTurnoCondicionesNecesariasPaseAAtaque(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais1, 3);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 3);
        juego.pasarTurno();
        Etapa etapaActual = juego.obtenerEtapaR();
        assertEquals( EtapaAtacar.class, etapaActual.getClass());
    }

    @Test
    public void test15JuegoAgregarMasFichasQLoPermitidoNoEsPosible(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        assertThrows(ExcepcionCantidadInvalida.class, () -> juego.colocarEjercitosFaseInicial(pais1, 7));
        assertEquals(1, pais1.cantidadDeEjercitos());
    }
    @Test
    public void test16JuegoTurno2AgregarMasFichasQLoPermitidoNoEsPosible(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        assertThrows(ExcepcionCantidadInvalida.class, () -> juego.colocarEjercitosFaseInicial(pais1, 7));
        juego.colocarEjercitosFaseInicial(pais1, 3);
        juego.pasarTurno();
        assertThrows(ExcepcionCantidadInvalida.class, () -> juego.colocarEjercitosFaseInicial(pais2, 7));
        juego.colocarEjercitosFaseInicial(pais2, 3);
        juego.pasarTurno();
        assertEquals(9, pais1.cantidadDeEjercitos());
        assertEquals(9, pais2.cantidadDeEjercitos());
    }

    @Test
    public void test17JuegoFaseAtacarPasaAreagrupar(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno(); //R1 2
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno(); //R2 1
        juego.colocarEjercitosFaseInicial(pais1, 3);
        juego.pasarTurno(); // R2 2
        juego.colocarEjercitosFaseInicial(pais2, 3);
        juego.pasarTurno(); //A1
        //ataca jugador1
        juego.pasarTurno();

        assertEquals(EtapaReagrupar.class, juego.obtenerEtapaR().getClass());
    }
    @Test
    public void test18JuegoFaseReagruparReagruparCorrectamente(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais1, 3);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 3);
        juego.pasarTurno();
        //ataca jugador1
        juego.pasarTurno();
        //reagrupajugador1
        juego.pasarTurno();
        //ataca jugador2
        juego.pasarTurno();
        //reagrupar jugador2
        Pais pais3 = juego.obtenerPais("Italia");
        juego.transferirEjercitos(pais2, pais3, 3);
        assertEquals(4, pais3.cantidadDeEjercitos());
        assertEquals(6, pais2.cantidadDeEjercitos());
    }
    @Test
    public void test19JuegoTerminaRondasAtaqueYReagruparPasaAColocacion(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais1, 3);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 3);
        juego.pasarTurno();
        //ataca jugador1
        juego.pasarTurno();
        //reagrupajugador1
        juego.pasarTurno();
        //ataca jugador2
        juego.pasarTurno();
        //reagrupar jugador2
        juego.pasarTurno();
        assertEquals(EtapaColocacion.class, juego.obtenerEtapaR().getClass());
    }
    @Test
    public void test20TurnoColocacionColocarCorrectamente() {
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais1, 3);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 3);
        juego.pasarTurno();
        //ataca jugador1
        juego.pasarTurno();
        //reagrupajugador1
        juego.pasarTurno();
        //ataca jugador2
        juego.pasarTurno();
        //reagrupar jugador2
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais1, 1);
        assertEquals(10, pais1.cantidadDeEjercitos());
    }
    @Test
    public void test21TurnoColocacionColocarCorrectamenteNoPoneSiSePasa(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais1, 3);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 3);
        juego.pasarTurno();
        //ataca jugador1
        juego.pasarTurno();
        //reagrupajugador1
        juego.pasarTurno();
        //ataca jugador2
        juego.pasarTurno();
        //reagrupar jugador2
        juego.pasarTurno();
        assertThrows(ExcepcionCantidadInvalida.class, () -> juego.colocarEjercitosFaseInicial(pais2, 30));
        assertEquals(9, pais2.cantidadDeEjercitos());
    }
    @Test
    public void test22FaltanColocarNoPasaElTurno(){
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais1, 3);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 3);
        juego.pasarTurno();
        //ataca jugador1
        juego.pasarTurno();
        //reagrupajugador1
        juego.pasarTurno();
        //ataca jugador2
        juego.pasarTurno();
        //reagrupar jugador2
        juego.pasarTurno();
        //entra en etapa colocacion
        assertThrows(ExcepcionPasarTurnoNoEsPosible.class, ()->juego.pasarTurno());
    }

    @Test
    public void test23JuegoEstablecerNombreyColorAJugadores() {
        Juego juego = new Juego(2);
        Jugador unJugador = juego.obtenerJugador(1);
        Jugador otroJugador = juego.obtenerJugador(2);

        juego.establecerNombreJugador(unJugador,"Juani");
        juego.establecerNombreJugador(otroJugador,"Cris");

        assertEquals("Juani", unJugador.obtenerNombre());
        assertEquals("Cris", otroJugador.obtenerNombre());

        juego.establecerColorAJugador(unJugador, Color.BLUE);
        juego.establecerColorAJugador(otroJugador, Color.BLACK);
        
        assertEquals(Color.BLUE, unJugador.obtenerFicha().color());
        assertEquals(Color.BLACK, otroJugador.obtenerFicha().color());
    }

    @Test
    public void test24JuegoFinalizarLanzaLaExcepcionFinDeJuego(){
        Juego juego = new Juego(1);
        Jugador jugador = juego.obtenerJugador(1);
        assertThrows(ExcepcionFinDeJuego.class, () -> juego.finalizar(jugador.obtenerNombre()));
    }

    @Test
    public void test25JuegoTerminaRondasAtaqueYReagruparPasaAColocacionOceaniaOcupado() {
        Juego juego = new Juego(2);
        juego.iniciarJuegoPrueba();
        Pais pais1 = juego.obtenerPais("Gran Bretania");
        Pais pais2 = juego.obtenerPais("Francia");
        juego.colocarEjercitosFaseInicial(pais1, 5);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 5);
        juego.pasarTurno();
        assertEquals(juego.obtenerJugadorJugando().obtenerFicha(), pais1.obtenerFicha());
        juego.colocarEjercitosFaseInicial(pais1, 3);
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais2, 3);
        juego.pasarTurno();
        //ataca jugador1
        juego.pasarTurno();
        //reagrupajugador1
        juego.pasarTurno();
        Pais unPais = juego.obtenerTablero().obtenerPais("Sumatra");
        unPais.asignarJugador(juego.obtenerJugadorJugando());
        //ataca jugador2
        juego.pasarTurno();
        //reagrupar jugador2
        juego.pasarTurno();
        juego.colocarEjercitosFaseInicial(pais1, 12);
        juego.pasarTurno();
        assertEquals(juego.obtenerJugadorJugando().obtenerFicha(), pais2.obtenerFicha());


        assertEquals(15, juego.cantidadEjercitosDisponibles());

    }
}
