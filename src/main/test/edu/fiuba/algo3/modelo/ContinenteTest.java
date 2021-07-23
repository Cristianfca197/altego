package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.continente.AmericaDelNorte;
import edu.fiuba.algo3.modelo.continente.AmericaDelSur;
import edu.fiuba.algo3.modelo.continente.Continente;
import edu.fiuba.algo3.modelo.juego.Pais;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ContinenteTest {

    @Test
    public void test01ContinenteSeCreaCorrectamente(){
        Continente unContinente = new AmericaDelNorte("America");
        assertNotNull(unContinente);
    }

    @Test
    public void test02ContinenteDevuelveElNombreCorrectamente(){
        Continente unContinente = new AmericaDelSur("America");
        assertEquals("America", unContinente.obtenerNombre());
    }

    @Test
    public void test03ContinenteGuardaCorrectamenteUnPaisYDevuelveElPais(){
        Continente unContinente = new AmericaDelNorte("America");
        Pais unPais = new Pais("Argentina");
        unContinente.aniadirPais(unPais);
        assertEquals(unPais, unContinente.obtenerPais("Argentina"));
    }

    @Test
    public void test04ContinenteDevulveUnaColeccionConLosPaises(){
        Continente unContinente = new AmericaDelNorte("America");
        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Colombia");
        unContinente.aniadirPais(unPais);
        unContinente.aniadirPais(otroPais);
        Collection paises = unContinente.obtenerPaises();
        assertNotNull(paises);

    }
    @Test
    public void test05AfricaEsOcupadoPorUnJugadorFichasExtraCorrectas(){
        Juego juego = new Juego(1);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        int cantidadEjercitos = 0;

        Continente continente = juego.obtenerTablero().obtenerContinente("Africa");
        cantidadEjercitos = continente.obtenerEjercitosExtra(juego.obtenerJugador(1));

        assertEquals(3, cantidadEjercitos);
    }
    @Test
    public void test06AmericaDelSurEsOcupadoPorUnJugadorFichasExtraCorrectas(){
        Juego juego = new Juego(1);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        int cantidadEjercitos = 0;

        Continente continente = juego.obtenerTablero().obtenerContinente("America del Sur");
        cantidadEjercitos = continente.obtenerEjercitosExtra(juego.obtenerJugador(1));

        assertEquals(3, cantidadEjercitos);
    }
    @Test
    public void test07AmericaDelNorteEsOcupadoPorUnJugadorFichasExtraCorrectas(){
        Juego juego = new Juego(1);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        int cantidadEjercitos = 0;

        Continente continente = juego.obtenerTablero().obtenerContinente("America del Norte");
        cantidadEjercitos = continente.obtenerEjercitosExtra(juego.obtenerJugador(1));

        assertEquals(5, cantidadEjercitos);
    }
    @Test
    public void test08EuropaEsOcupadoPorUnJugadorFichasExtraCorrectas(){
        Juego juego = new Juego(1);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        int cantidadEjercitos = 0;

        Continente continente = juego.obtenerTablero().obtenerContinente("Europa");
        cantidadEjercitos = continente.obtenerEjercitosExtra(juego.obtenerJugador(1));

        assertEquals(5, cantidadEjercitos);
    }
    @Test
    public void test08AsiaEsOcupadoPorUnJugadorFichasExtraCorrectas(){
        Juego juego = new Juego(1);
        juego.repartirPaisesCondicionesConocidas();
        juego.ocuparTablero();
        int cantidadEjercitos = 0;

        Continente continente = juego.obtenerTablero().obtenerContinente("Asia");
        cantidadEjercitos = continente.obtenerEjercitosExtra(juego.obtenerJugador(1));

        assertEquals(7, cantidadEjercitos);
    }
}
