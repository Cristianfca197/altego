package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CanjeTest {
    @Test
    public void test01CanjeDeTresPaisesConElMismoSimboloEsPosible (){
        TarjetaPais primertarjeta = new TarjetaPais(new Globo(), "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(new Globo(), "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(new Globo(), "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();

        assertEquals(4, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test02CanjeDeTresPaisesConDistintoSimboloEsPosible (){
        TarjetaPais primertarjeta = new TarjetaPais(new Globo(), "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(new Barco(), "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(new Canion(), "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();

        assertEquals(4, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test03CanjeDeTresPaisesConSoloDosSimbolosIgualesNoEsPosible (){
        TarjetaPais primertarjeta = new TarjetaPais(new Globo(), "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(new Globo(), "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(new Barco(), "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();

        assertEquals(0, canje.realizarCanje(listaDeTarjetas));
    }
}
