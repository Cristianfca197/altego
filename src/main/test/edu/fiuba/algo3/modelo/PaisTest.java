package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaisTest {
    @Test
    public void test01PaisEsLimitrofeEsTrueConPaisesLimitrofes(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoAzul);

        unPais.sonLimitrofesEntre(otroPais);
        assertTrue(unPais.esLimitrofeCon(otroPais));
    }

    @Test
    public void test02PaisEsLimitrofeEsFalseConPaisesNoLimitrofes(){
        Jugador equipoAzul = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Colombia", equipoAzul);

        assertFalse(unPais.esLimitrofeCon(otroPais));
    }
    @Test
    public void test03CreoDosPaisesConDosFichasYSonDistintas(){
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
    
        Pais unPais = new Pais("Arg", unJugador);
        Pais otroPais = new Pais("Bra", otroJugador);

        assertNotEquals(unPais.obtenerFicha(), otroPais.obtenerFicha());
        assertFalse(unPais.obtenerFicha().esIgualA(otroPais.obtenerFicha()));
    }
}
