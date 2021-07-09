package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtacarPaisEnemigoYConquistarPais {

    @Test
    public void test01JugadorAtacaYDefensorGanaElCombate(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);

        batalla.combateEntre(unPais, otroPais);
        assertNotEquals(otroPais.obtenerFicha(), equipoAzul.obtenerFicha());
    }

    @Test
    public void test02JugadorAtacaYGanaElCombate(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(5, equipoAzul.obtenerFicha());

        batalla.combateEntre(unPais, otroPais);
        assertEquals(unPais.obtenerFicha(), otroPais.obtenerFicha());
    }
    @Test
    public void test03JugadorAtacaYDefensorGanaElCombateDisminuyeElEjercitoDelAtacante(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(2, unPais.obtenerFicha());/*Un pais queda con 3 ejercitos*/

        batalla.combateEntre(unPais, otroPais);
        assertNotEquals(2, unPais.cantidadDeEjercitos());
    }

    @Test
    public void test04JugadorAtacaYGanaElCombateDisminuyeElEjercitoDelDefensor(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(2, unPais.obtenerFicha());/*Un pais queda con 3 ejercitos*/
        otroPais.colocarEjercitos(1, unPais.obtenerFicha());/*Otro pais queda con 2 ejercitos*/

        batalla.combateEntre(unPais, otroPais);
        assertNotEquals(1, otroPais.cantidadDeEjercitos());
    }

}
