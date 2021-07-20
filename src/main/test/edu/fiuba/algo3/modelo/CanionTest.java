package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CanionTest {
    @Test
    public void test01CreacionDeCanionEsCorrecta(){
        Canion canion = new Canion();
        assertNotNull(canion);
    }
    @Test
    public void test02CanionDevuelveElNombreCorrectamente(){
        Canion canion = new Canion();
        assertEquals("Canion", canion.obtenerNombre());
    }
    @Test
    public void test03CanionDevuelveTrueSiEsIgualConCanion(){
        Canion canion = new Canion();
        assertTrue(canion.esIgual(canion));
    }
    @Test
    public void test04CanionDevuelveFalseSiEsIgualConBarco(){
        Canion canion = new Canion();
        assertFalse(canion.esIgual(new Barco()));
    }
    @Test
    public void test05CanionDevuelveFalseSiEsIgualConGlobo(){
        Canion canion = new Canion();
        assertFalse(canion.esIgual(new Globo()));
    }
    @Test
    public void test06CanionDevuelveTrueSiEsIgualConComodin(){
        Canion canion = new Canion();
        assertTrue(canion.esIgual(new Comodin()));
    }
}
