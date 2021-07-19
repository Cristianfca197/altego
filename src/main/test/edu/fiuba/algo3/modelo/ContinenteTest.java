package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContinenteTest {

    @Test
    public void test01ContinenteSeCreaCorrectamente(){
        Continente unContinente = new Continente("America");
        assertEquals("America", unContinente.obtenerNombre());
    }

    @Test
    public void test02ContinenteDevuelveUnaColeccionDeLosPaisesPropios(){
        Continente unContinente = new Continente("America");
        Pais unPais = new Pais("Argentina");

        unContinente.aniadirPais(unPais);
        assertTrue( unContinente.obtenerPaises().contains(unPais));
    }
}
