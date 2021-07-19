package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazoTarjetasPaisTest {

    @Test
    public void test01MazoTarjetasSeCreaVacioYSeAgregaUnCañonCorrectamente(){
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Canion(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(1, tarjetas.cantidadCaniones());
    }
    @Test
    public void test02MazoTarjetasSeCreaVacioYSeAgregaUnBarcoCorrectamente(){
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Barco(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(1, tarjetas.cantidadBarcos());
    }
    @Test
    public void test03MazoTarjetasSeCreaVacioYSeAgregaUnGLoboCorrectamente(){
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Globo(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(1, tarjetas.cantidadGlobos());
    }
    @Test
    public void test04MazoTarjetasSeCreaVacioYSeAgregaUnComodinCorrectamente(){
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Comodin(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(1, tarjetas.cantidadComodines());
    }

    @Test
    public void test05EsCanjeValidoEsTrueSiTieneTresTarjetasGloboIguales(){
        Globo globo = new Globo();
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta1 = new TarjetaPais(globo, "Argentina");
        TarjetaPais tarjeta2 = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais tarjeta3 = new TarjetaPais(globo, "Japon");
        tarjetas.agregarTarjeta(tarjeta1);
        tarjetas.agregarTarjeta(tarjeta2);
        tarjetas.agregarTarjeta(tarjeta3);
        assertTrue(tarjetas.esCanjeValido());
    }
    @Test
    public void test06EsCanjeValidoEsTrueSiTieneTresTarjetasBarcoIguales(){
        Barco barco = new Barco();
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta1 = new TarjetaPais(barco, "Argentina");
        TarjetaPais tarjeta2 = new TarjetaPais(barco, "Inglaterra");
        TarjetaPais tarjeta3 = new TarjetaPais(barco, "Japon");
        tarjetas.agregarTarjeta(tarjeta1);
        tarjetas.agregarTarjeta(tarjeta2);
        tarjetas.agregarTarjeta(tarjeta3);
        assertTrue(tarjetas.esCanjeValido());
    }

    @Test
    public void test06EsCanjeValidoEsTrueSiTieneTresTarjetasCanionIguales(){
        Canion canion = new Canion();
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta1 = new TarjetaPais(canion, "Argentina");
        TarjetaPais tarjeta2 = new TarjetaPais(canion, "Inglaterra");
        TarjetaPais tarjeta3 = new TarjetaPais(canion, "Japon");
        tarjetas.agregarTarjeta(tarjeta1);
        tarjetas.agregarTarjeta(tarjeta2);
        tarjetas.agregarTarjeta(tarjeta3);
        assertTrue(tarjetas.esCanjeValido());
    }

    @Test
    public void test07EsCanjeValidoEsTrueSiTieneDosTarjetasIgualesYComodin(){
        Canion canion = new Canion();
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta1 = new TarjetaPais(canion, "Argentina");
        TarjetaPais tarjeta2 = new TarjetaPais(canion, "Inglaterra");
        TarjetaPais tarjeta3 = new TarjetaPais(new Comodin(), "Japon");
        tarjetas.agregarTarjeta(tarjeta1);
        tarjetas.agregarTarjeta(tarjeta2);
        tarjetas.agregarTarjeta(tarjeta3);
        assertTrue(tarjetas.esCanjeValido());
    }

    @Test
    public void test07EsCanjeValidoEsTrueSiTieneUnaTarjetasYDosComodin(){
        Comodin comodin = new Comodin();
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta1 = new TarjetaPais(new Canion(), "Argentina");
        TarjetaPais tarjeta2 = new TarjetaPais(comodin, "Inglaterra");
        TarjetaPais tarjeta3 = new TarjetaPais(comodin, "Japon");
        tarjetas.agregarTarjeta(tarjeta1);
        tarjetas.agregarTarjeta(tarjeta2);
        tarjetas.agregarTarjeta(tarjeta3);
        assertTrue(tarjetas.esCanjeValido());
    }
}
