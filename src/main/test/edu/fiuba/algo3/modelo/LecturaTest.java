package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.continente.Continente;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoObjetivos;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoPaises;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoTarjetas;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void test07LeerObjetivosTerceroEsCorrecto(){
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        Objetivo objetivo;
        leer.leerArchivo(objetivos);

        objetivo = objetivos.get(3);
        assertEquals("Ocupar", objetivo.obtenerTipo());
        assertEquals(4, objetivo.paisesAConquistar("Asia"));
        assertEquals(2, objetivo.paisesAConquistar("America del Sur"));
        assertEquals(Arrays.asList("Europa"), objetivo.continentesAOcupar());

    }

    @Test
    public void test08LeerObjetivosQuintoEsCorrecto(){
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        Objetivo objetivo;
        leer.leerArchivo(objetivos);

        objetivo = objetivos.get(5);
        assertEquals("Ocupar", objetivo.obtenerTipo());
        assertEquals(4, objetivo.paisesAConquistar("America del Norte"));
        assertEquals(2, objetivo.paisesAConquistar("Oceania"));
        assertEquals(2, objetivo.paisesAConquistar("America del Sur"));
        assertEquals(2, objetivo.paisesAConquistar("Africa"));
        assertEquals(3, objetivo.paisesAConquistar("Europa"));
        assertEquals(3, objetivo.paisesAConquistar("Asia"));

        assertTrue(objetivo.continentesAOcupar().isEmpty());
    }

    @Test
    public void test09LeerObjetivosSeptimoEsCorrecto(){
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        Objetivo objetivo;
        leer.leerArchivo(objetivos);

        objetivo = objetivos.get(7);
        assertEquals("Ocupar", objetivo.obtenerTipo());
        assertEquals(Arrays.asList("América del Sur", "África"), objetivo.continentesAOcupar());
    }

    @Test
    public void test10LeerObjetivosTreceEsCorrecto(){
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        Objetivo objetivo;
        leer.leerArchivo(objetivos);

        objetivo = objetivos.get(13);
        assertEquals("Destruir", objetivo.obtenerTipo());
        assertEquals("Magenta", objetivo.equipoADestruir());
    }

    @Test
    public void test11LeerObjetivosComunesEsCorrecto(){
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo objetivo1 = objetivos.get(1);
        Objetivo objetivo4 = objetivos.get(4);
        Objetivo objetivo6 = objetivos.get(6);
        
        
        assertEquals(30, objetivo1.cantidadObjetivoComun());
        assertEquals(30, objetivo4.cantidadObjetivoComun());
        assertEquals(30, objetivo6.cantidadObjetivoComun());
        
    }

    
}
