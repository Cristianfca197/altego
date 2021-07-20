package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GloboTest {
    @Test
    public void test01CreacionDeGloboEsCorrecta(){
        Globo globo = new Globo();
        assertNotNull(globo);
    }
    @Test
    public void test02GloboDevuelveElNombreCorrectamente(){
        Globo globo = new Globo();
        assertEquals("Globo", globo.obtenerNombre());
    }
    @Test
    public void test03GloboDevuelveTrueSiEsIgualConGlobo(){
        Globo globo = new Globo();
        assertTrue(globo.esIgual(globo));
    }
    @Test
    public void test04GloboDevuelveFalseSiEsIgualConBarco(){
        Globo globo = new Globo();
        assertFalse(globo.esIgual(new Barco()));
    }
    @Test
    public void test05GloboDevuelveFalseSiEsIgualConCanion(){
        Globo globo = new Globo();
        assertFalse(globo.esIgual(new Canion()));
    }
    @Test
    public void test06GloboDevuelveTrueSiEsIgualConComodin(){
        Globo globo = new Globo();
        assertTrue(globo.esIgual(new Comodin()));
    }
}


