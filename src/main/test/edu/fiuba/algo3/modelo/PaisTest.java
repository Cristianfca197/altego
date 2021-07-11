package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaisTest {
    @Test
    public void test01PaisSeCreaCon1FichaDelJugadorCorrecto(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);

        assertEquals(equipoAzul.obtenerFicha(),unPais.obtenerFicha());
    }
    @Test
    public void test02PaisSeCreaCon1Ejercito(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);

       assertEquals(1, unPais.cantidadDeEjercitos());
    }
    @Test
    public void test03PaisEsLimitrofeEsTrueConPaisesLimitrofes(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoAzul);

        unPais.sonLimitrofesEntre(otroPais);
        assertTrue(unPais.esLimitrofeCon(otroPais));
    }

    @Test
    public void test04PaisEsLimitrofeEsFalseConPaisesNoLimitrofes(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Colombia", equipoAzul);

        assertFalse(unPais.esLimitrofeCon(otroPais));
    }
    @Test
    public void test05CreoDosPaisesConDosFichasYSonDistintas(){
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
    
        Pais unPais = new Pais("Arg", unJugador);
        Pais otroPais = new Pais("Bra", otroJugador);

        assertNotEquals(unPais.obtenerFicha(), otroPais.obtenerFicha());
        assertFalse(unPais.obtenerFicha().esIgualA(otroPais.obtenerFicha()));
    }
}
