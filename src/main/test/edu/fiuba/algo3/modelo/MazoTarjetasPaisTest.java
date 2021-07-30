package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.juego.MazoTarjetasPais;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.tipoTarjeta.Barco;
import edu.fiuba.algo3.modelo.tipoTarjeta.Canion;
import edu.fiuba.algo3.modelo.tipoTarjeta.Comodin;
import edu.fiuba.algo3.modelo.tipoTarjeta.Globo;

import static org.junit.jupiter.api.Assertions.*;

public class MazoTarjetasPaisTest {

    @Test
    public void test01MazoTarjetasSeCreaVacioYSeAgregaUnCanionCorrectamente() {
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Canion(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(tarjeta, tarjetas.obtenerTarjetas().remove(0));
    }

    @Test
    public void test02MazoTarjetasSeCreaVacioYSeAgregaUnBarcoCorrectamente(){
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Barco(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(tarjeta, tarjetas.obtenerTarjetas().remove(0));
    }
    @Test
    public void test03MazoTarjetasSeCreaVacioYSeAgregaUnGLoboCorrectamente(){
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Globo(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(tarjeta, tarjetas.obtenerTarjetas().remove(0));
    }
    @Test
    public void test04MazoTarjetasSeCreaVacioYSeAgregaUnComodinCorrectamente(){
        MazoTarjetasPais tarjetas = new MazoTarjetasPais();
        TarjetaPais tarjeta = new TarjetaPais(new Comodin(), "Argentina");

        tarjetas.agregarTarjeta(tarjeta);

        assertEquals(tarjeta, tarjetas.obtenerTarjetas().remove(0));
    }
}