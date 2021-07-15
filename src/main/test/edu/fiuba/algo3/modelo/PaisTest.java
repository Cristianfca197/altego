package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaisTest {
    @Test
    public void test01PaisSeCreaCon1FichaDelJugadorCorrecto(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina");
        unPais.asignarJugador(equipoAzul);

        assertEquals(equipoAzul.obtenerFicha(),unPais.obtenerFicha());
    }
    @Test
    public void test02PaisSeCreaCon1Ejercito(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina");
        unPais.asignarJugador(equipoAzul);

       assertEquals(1, unPais.cantidadDeEjercitos());
    }
    @Test
    public void test03PaisEsLimitrofeEsTrueConPaisesLimitrofes(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");
        unPais.asignarJugador(equipoAzul);
        otroPais.asignarJugador(equipoAzul);

        unPais.sonLimitrofesEntre(otroPais);
        assertTrue(unPais.esLimitrofeCon(otroPais));
    }

    @Test
    public void test04PaisEsLimitrofeEsFalseConPaisesNoLimitrofes(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Colombia");
        unPais.asignarJugador(equipoAzul);
        otroPais.asignarJugador(equipoAzul);

        assertFalse(unPais.esLimitrofeCon(otroPais));
    }
    @Test
    public void test05CreoDosPaisesConDosFichasYSonDistintas(){
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
    
        Pais unPais = new Pais("Arg");
        Pais otroPais = new Pais("Bra");
        unPais.asignarJugador(unJugador);
        otroPais.asignarJugador(otroJugador);

        assertNotEquals(unPais.obtenerFicha(), otroPais.obtenerFicha());
        assertFalse(unPais.obtenerFicha().esIgualA(otroPais.obtenerFicha()));
    }
    @Test
    public void test06AtaqueSeRealizaSinInconvenientes()throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");
        unPais.asignarJugador(equipoAzul);
        otroPais.asignarJugador(equipoRojo);

        unPais.colocarEjercitos(2, equipoAzul.obtenerFicha());/*Un pais queda con 3 ejercitos*/
        otroPais.colocarEjercitos(1, equipoRojo.obtenerFicha());/*Otro pais queda con 2 ejercitos*/
        unPais.sonLimitrofesEntre(otroPais);

        assertDoesNotThrow(() -> {unPais.atacarA(otroPais);});
    }

    @Test
    public void test07AtacarAPaiseAliadoNoEsPosible() {
        Jugador equipoAzul = new Jugador();
        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Chile");
        unPais.asignarJugador(equipoAzul);
        otroPais.asignarJugador(equipoAzul);

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {unPais.atacarA(otroPais);});
    }

    @Test
    public void test08AtacarAPaiseNoLimitrofeNoEsPosible() throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Colombia");
        unPais.asignarJugador(equipoAzul);
        unPais.asignarJugador(equipoRojo);

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {unPais.atacarA(otroPais);});

    }

    @Test
    public void test09AtacarAPaisConAtacanteConMenosDe2EjercitosNoEsPosible() throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Brasil");
        unPais.asignarJugador(equipoAzul);
        otroPais.asignarJugador(equipoRojo);

        otroPais.colocarEjercitos(2, equipoRojo.obtenerFicha());

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {unPais.atacarA(otroPais);});
    }
}
