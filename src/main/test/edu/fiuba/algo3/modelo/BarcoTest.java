package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BarcoTest {
    @Test
    public void test01CreacionDeBarcoEsCorrecta(){
        Barco barco = new Barco();
        assertNotNull(barco);
    }
    @Test
    public void test02BarcoDevuelveElNombreCorrectamente(){
        Barco barco = new Barco();
        assertEquals("Barco", barco.obtenerNombre());
    }
    @Test
    public void test03BarcoDevuelveTrueSiEsIgualConBarco(){
        Barco barco = new Barco();
        assertTrue(barco.esIgual(barco));
    }
    @Test
    public void test04BarcoDevuelveFalseSiEsIgualConGlobo(){
        Barco barco = new Barco();
        assertFalse(barco.esIgual(new Globo()));
    }
    @Test
    public void test05BarcoDevuelveFalseSiEsIgualConCanion(){
        Barco barco = new Barco();
        assertFalse(barco.esIgual(new Canion()));
    }
    @Test
    public void test06BarcoDevuelveTrueSiEsIgualConComodin(){
        Barco barco = new Barco();
        assertTrue(barco.esIgual(new Comodin()));
    }
}
