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
    
    @Test
    public void batallaConPaisesNoLimitrofesNoEsPosible() throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Argentina", equipoRojo);
        Batalla batalla = new Batalla();

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {batalla.combateEntre(unPais, otroPais);});

    }

    @Test
    public void batallaConPaiseAtacanteConMenosDe2EjercitosNoEsPosible() throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Argentina", equipoRojo);
        unPais.colocarEjercitos(2, unPais.obtenerFicha());
        otroPais.colocarEjercitos(2, otroPais.obtenerFicha());
        Batalla batalla = new Batalla();

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {batalla.combateEntre(unPais, otroPais);});
    }
}
