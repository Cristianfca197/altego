package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BatallaTest {

    @Test
    public void test01BatallasIndividualesDisminuyeElEjercitoDelPaisConDadosMasChicos(){
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
    @Test
    public void test02BatallasIndividualesEmpateDeDadosDisminuyeElEjercitoDelPaisAtacante(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);

        unPais.colocarEjercitos(1, equipoAzul.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(6);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);
        assertEquals(1, unPais.cantidadDeEjercitos());
    }

    @Test
    public void test03BatallasIndividualesAtacantePierde2EjercitosDefensorPierde1(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);

        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(2, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(4);
        dadosUnPais.add(3);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(6);
        dadosOtroPais.add(5);
        dadosOtroPais.add(1);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);

        assertEquals(2, unPais.cantidadDeEjercitos());
        assertEquals(2, otroPais.cantidadDeEjercitos());
    }

    @Test
    public void test04BatallasIndividualesGanaElAtacanteYOcupaElPais(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);
        assertEquals(unPais.obtenerFicha(), otroPais.obtenerFicha());
    }

    @Test
    public void test05BatallasIndividualesGanaElAtacanteYOcupaElPaisCantidadDeFichasEsLaCorrecta(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(2, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(6);
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);


        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);

        assertEquals(1, unPais.cantidadDeEjercitos());
        assertEquals(3, otroPais.cantidadDeEjercitos());

    }

    @Test
    public void test06BatallasIndividualesGanaElAtacantePeroNoOcupaElPais(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(4, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(6);
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);

        assertNotEquals(unPais.obtenerFicha(), otroPais.obtenerFicha());
    }

    @Test
    public void test07BatallasIndividualesGanaElAtacantePeroNoOcupaElPaisFichasDefensorSonLasCorrectas(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(4, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(6);
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);

        assertEquals( 2,otroPais.cantidadDeEjercitos());
    }

    @Test
    public void test08BatallasIndividualesGanaElAtacantePeroNoOcupaElPaisFichasAtacanteSonLasCorrectas(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(4, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(6);
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais, dadosOtroPais);

        assertEquals(4, unPais.cantidadDeEjercitos());
    }
}
