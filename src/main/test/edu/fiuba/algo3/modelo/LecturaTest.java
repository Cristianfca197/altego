package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.continente.Continente;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoPaises;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoTarjetas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class LecturaTest {
    @Test
    public void test01LeerTarjetasTartariaEsCorrecta(){
        LecturaArchivoTarjetas leer = new LecturaArchivoTarjetas();
        HashMap<String, TarjetaPais> tarjetasDePais;
        TarjetaPais tarjeta;
        leer.leerArchivos();
        tarjetasDePais = leer.getTarjetas();

        tarjeta = tarjetasDePais.get("Tartaria");
        assertTrue(tarjeta.obtenerTipo().esCanion());
    }
    @Test
    public void test02LeerTarjetasArgentinaEsCorrecta(){
        LecturaArchivoTarjetas leer = new LecturaArchivoTarjetas();
        HashMap<String, TarjetaPais> tarjetasDePais;
        TarjetaPais tarjeta;
        leer.leerArchivos();
        tarjetasDePais = leer.getTarjetas();

        tarjeta = tarjetasDePais.get("Argentina");

        assertTrue(tarjeta.obtenerTipo().esCanion());
        assertTrue(tarjeta.obtenerTipo().esBarco());
        assertTrue(tarjeta.obtenerTipo().esGlobo());
    }
    @Test
    public void test03LeerTarjetasGranBretaniaEsCorrecta(){
        LecturaArchivoTarjetas leer = new LecturaArchivoTarjetas();
        HashMap<String, TarjetaPais> tarjetasDePais;
        TarjetaPais tarjeta;
        leer.leerArchivos();
        tarjetasDePais = leer.getTarjetas();

        tarjeta = tarjetasDePais.get("Gran Bretaña");

        assertTrue(tarjeta.obtenerTipo().esBarco());

    }

    @Test
    public void test04LeerTarjetasRusiaEsCorrecta(){
        LecturaArchivoTarjetas leer = new LecturaArchivoTarjetas();
        HashMap<String, TarjetaPais> tarjetasDePais;
        TarjetaPais tarjeta;
        leer.leerArchivos();
        tarjetasDePais = leer.getTarjetas();

        tarjeta = tarjetasDePais.get("Rusia");

        assertTrue(tarjeta.obtenerTipo().esGlobo());

    }
    @Test
    public void test05LeerPaisesContintentesSonCorrectos(){
        LecturaArchivoPaises leer = new LecturaArchivoPaises();
        LecturaArchivoTarjetas leerTarjetas = new LecturaArchivoTarjetas();
        Tablero tablero = new Tablero();

        HashMap<String, TarjetaPais> tarjetasDePais;
        leerTarjetas.leerArchivos();
        tarjetasDePais = leerTarjetas.getTarjetas();

        leer.leerArchivo(tarjetasDePais, tablero);
        assertEquals(tablero.obtenerContinente("America del Sur").obtenerNombre(),"America del Sur");
        assertEquals(tablero.obtenerContinente("Asia").obtenerNombre(), "Asia");
        assertEquals(tablero.obtenerContinente("America del Norte").obtenerNombre(), "America del Norte");
        assertEquals(tablero.obtenerContinente("Oceania").obtenerNombre(), "Oceania");
        assertEquals(tablero.obtenerContinente("Europa").obtenerNombre(), "Europa");

    }

    @Test
    public void test06LeerPaisesUruguayLeidoCorrectamente(){
        LecturaArchivoPaises leer = new LecturaArchivoPaises();
        LecturaArchivoTarjetas leerTarjetas = new LecturaArchivoTarjetas();
        Tablero tablero = new Tablero();

        HashMap<String, TarjetaPais> tarjetasDePais;
        leerTarjetas.leerArchivos();
        tarjetasDePais = leerTarjetas.getTarjetas();

        leer.leerArchivo(tarjetasDePais, tablero);

        Continente continente = tablero.obtenerContinente("America del Sur");
        Pais uruguay = continente.obtenerPais("Uruguay");
        Pais argentina = continente.obtenerPais("Argentina");
        Pais brasil = continente.obtenerPais("Brasil");

        assertEquals(uruguay.obtenerNombre(), "Uruguay");
        assertEquals(uruguay.continenteNombre() , "America del Sur");
        assertTrue(uruguay.esLimitrofeCon(argentina));
        assertTrue(uruguay.esLimitrofeCon(brasil));

    }
}
