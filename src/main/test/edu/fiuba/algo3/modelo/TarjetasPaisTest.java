package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarjetasPaisTest {

    @Test
    public void test01TarjetasSeCreaVacioYSeAgregaUnCañonCorrectamente(){
        TarjetasPais tarjetas = new TarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Canion(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(1, tarjetas.cantidadCaniones());
    }
    @Test
    public void test02TarjetasSeCreaVacioYSeAgregaUnBarcoCorrectamente(){
        TarjetasPais tarjetas = new TarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Barco(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(1, tarjetas.cantidadBarcos());
    }
    @Test
    public void test03TarjetasSeCreaVacioYSeAgregaUnGLoboCorrectamente(){
        TarjetasPais tarjetas = new TarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Globo(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(1, tarjetas.cantidadGlobos());
    }
    @Test
    public void test04TarjetasSeCreaVacioYSeAgregaUnComodinCorrectamente(){
        TarjetasPais tarjetas = new TarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Comodin(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(1, tarjetas.cantidadComodines());
    }
}
