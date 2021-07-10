package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BatallaTest {

    @Test
    public void test01BatallaConPaisesAliadosNoEsPosible() {
        Jugador equipoAzul = new Jugador();
        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Argentina", equipoAzul);
        Batalla batalla = new Batalla();

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {batalla.combateEntre(unPais, otroPais);});
    }
}
