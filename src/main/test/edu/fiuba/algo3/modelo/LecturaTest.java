package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;


public class LecturaTest {
    @Test
    public void test01LeerTarjetas(){
        LecturaArchivoTarjetas leer = new LecturaArchivoTarjetas();

        leer.leerArchivos();
    }
    @Test
    public void test02LeerPaises(){
        LecturaArchivoPaises leer = new LecturaArchivoPaises();

        leer.leerArchivo();
    }


}
