package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ContinenteTest {

    @Test
    public void test01ContinenteSeCreaCorrectamente(){
        Continente unContinente = new Continente("America");
        assertNotNull(unContinente);
    }

    @Test
    public void test02ContinenteDevuelveElNombreCorrectamente(){
        Continente unContinente = new Continente("America");
        assertEquals("America", unContinente.obtenerNombre());
    }

    @Test
    public void test03ContinenteGuardaCorrectamenteUnPaisYDevuelveElPais(){
        Continente unContinente = new Continente("America");
        Pais unPais = new Pais("Argentina");
        unContinente.aniadirPais(unPais);
        assertEquals(unPais, unContinente.obtenerPais("Argentina"));
    }

    @Test
    public void test04ContinenteDevulveUnaColeccionConLosPaises(){
        Continente unContinente = new Continente("America");
        Pais unPais = new Pais("Argentina");
        Pais otroPais = new Pais("Colombia");
        unContinente.aniadirPais(unPais);
        unContinente.aniadirPais(otroPais);
        Collection paises = unContinente.obtenerPaises();
        assertNotNull(paises);

    }
}
