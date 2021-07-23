package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.juego.Ficha;

import static org.junit.jupiter.api.Assertions.*;

public class FichaTest {
    @Test
    public void test01FichaSeCreaCorrectamente(){
        Ficha ficha = new Ficha();
        assertNotNull(ficha);
    }
    @Test
    public void test02FichaEsIgualEsTrueConFichaIgual(){
        Ficha ficha = new Ficha();
        assertTrue(ficha.esIgualA(ficha));
    }
    @Test
    public void test03FichaEsIgualEsFalseConFichaDistinta(){
        Ficha ficha = new Ficha();
        assertFalse(ficha.esIgualA(new Ficha()));
    }
}
