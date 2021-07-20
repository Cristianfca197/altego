package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComodinTest {
    @Test
    public void test01CreacionDeComodinEsCorrecta(){
        Comodin comodin = new Comodin();
        assertNotNull(comodin);
    }
    @Test
    public void test02ComodinDevuelveElNombreCorrectamente(){
        Comodin comodin = new Comodin();
        assertEquals("Comodin", comodin.obtenerNombre());
    }
    @Test
    public void test03ComodinDevuelveTrueSiEsIgualConComodin(){
        Comodin comodin = new Comodin();
        assertTrue(comodin.esIgual(comodin));
    }
    @Test
    public void test04ComodinDevuelveTrueSiEsIgualConBarco(){
        Comodin comodin = new Comodin();
        assertTrue(comodin.esIgual(new Barco()));
    }
    @Test
    public void test05ComodinDevuelveTrueSiEsIgualConGlobo(){
        Comodin comodin = new Comodin();
        assertTrue(comodin.esIgual(new Globo()));
    }
    @Test
    public void test06ComodinDevuelveTrueSiEsIgualConCanion(){
        Comodin comodin = new Comodin();
        assertTrue(comodin.esIgual(new Canion()));
    }
}
