package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CanjeTest {
    @Test
    public void test01CanjeDeTresPaisesConElMismoSimboloEsPosible (){
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();

        assertEquals(4, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test02CanjeDeTresPaisesConDistintoSimboloEsPosible (){
        Globo globo = new Globo();
        Barco barco = new Barco();
        Canion canion = new Canion();

        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(barco, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(canion, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();

        assertEquals(4, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test03CanjeDeTresPaisesConSoloDosSimbolosIgualesNoEsPosible (){
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(new Barco(), "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();

        assertEquals(0, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test04SegundoCanjeDeTresPaisesConElMismoSimboloEsPosible (){
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        SegundoCanje canje = new SegundoCanje();

        assertEquals(7, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test05TercerCanjeDeTresPaisesConElMismoSimboloEsPosible (){
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        TercerCanje canje = new TercerCanje();

        assertEquals(10, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test06CuartoCanjeDeTresPaisesConElMismoSimboloEsPosible (){
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        CuartoOMasCanjes canje = new CuartoOMasCanjes();

        assertEquals(15, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test06CuartoYQuintoCanjeDeTresPaisesConElMismoSimboloEsPosible (){
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        CuartoOMasCanjes canje = new CuartoOMasCanjes();
        canje.realizarCanje(listaDeTarjetas);
        assertEquals(20, canje.realizarCanje(listaDeTarjetas));
    }
}
