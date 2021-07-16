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
}
