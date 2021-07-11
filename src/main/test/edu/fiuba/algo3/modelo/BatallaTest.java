package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BatallaTest {

    @Test
    public void test01BatallaConPaisesAliadosNoEsPosible() {
        Jugador equipoAzul = new Jugador();
        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Chile", equipoAzul);
        Batalla batalla = new Batalla();

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {batalla.combateEntre(unPais, otroPais);});
    }
    
    @Test
    public void batallaConPaisesNoLimitrofesNoEsPosible() throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Colombia", equipoRojo);
        Batalla batalla = new Batalla();

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {batalla.combateEntre(unPais, otroPais);});

    }

    @Test
    public void batallaConPaiseAtacanteConMenosDe2EjercitosNoEsPosible() throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(2, unPais.obtenerFicha());
        otroPais.colocarEjercitos(2, otroPais.obtenerFicha());
        Batalla batalla = new Batalla();

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {batalla.combateEntre(unPais, otroPais);});
    }

    @Test
    public void batallasIndividualesDisminuyeElEjercitoDelPaisConDadosMasChicos(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(1);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);
        assertEquals(0, otroPais.cantidadDeEjercitos());
    }
}
