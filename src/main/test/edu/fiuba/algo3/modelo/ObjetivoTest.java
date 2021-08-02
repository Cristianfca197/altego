package edu.fiuba.algo3.modelo;
 
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoObjetivos;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjetivoTest {

    @Test
    public void test01ObjetivoDestruirDesapareceEquipoAzulCumplido(){

        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(8); // Destruir el ejército azul de ser imposible al jugador de la derecha
        Juego unJuego = new Juego(4);
        unJuego.iniciarJuegoPrueba();
        unJuego.obtenerJugador(3).establecerObjetivo(obj);
        obj.asignarJugador(unJuego.obtenerJugador(3));

        ArrayList<Pais> paises = unJuego.obtenerTablero().obtenerPaises();

        for (Pais p : paises) {
            if (p.perteneceA(unJuego.obtenerJugador(4))){
                p.cambiarFicha(unJuego.obtenerJugador(2).obtenerFicha());
            }
        }

        obj.actualizar(unJuego);

        assertTrue(obj.estaCumplido());
    }

    @Test
    public void test02ObjetivoDestruirDesapareceEquipoRojoNoExisteCumplido(){
    
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(10); // Destruir el ejército Negro de ser imposible 
                                          // al jugador de la derecha
        Juego unJuego = new Juego(4);
        unJuego.iniciarJuegoPrueba();
        unJuego.obtenerJugador(3).establecerObjetivo(obj);
        obj.asignarJugador(unJuego.obtenerJugador(3));

        ArrayList<Pais> paises = unJuego.obtenerTablero().obtenerPaises();

        for (Pais p : paises) {
            if (p.perteneceA(unJuego.obtenerJugador(4))){
                p.cambiarFicha(unJuego.obtenerJugador(2).obtenerFicha());
            }
        }
        
        obj.actualizar(unJuego);                 
        assertTrue(obj.estaCumplido());
    }

    @Test
    public void test03ObjetivoDestruirEquipoMagentaNoExisteCumplido(){
    
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(13); // Destruir el ejército Negro de ser imposible 
                                          // al jugador de la derecha
        Juego unJuego = new Juego(4);
        unJuego.iniciarJuegoPrueba();
        unJuego.obtenerJugador(4).establecerObjetivo(obj); // Se lo asigno al ultimo jugador.
        obj.asignarJugador(unJuego.obtenerJugador(4));     // El siguiente "a la derecha" es el primero.

        ArrayList<Pais> paises = unJuego.obtenerTablero().obtenerPaises();

        for (Pais p : paises) {
            if (p.perteneceA(unJuego.obtenerJugador(1))){
                p.cambiarFicha(unJuego.obtenerJugador(2).obtenerFicha());
            }
        }
        
        obj.actualizar(unJuego);                 
        assertTrue(obj.estaCumplido());
    }

    @Test
    public void test04ObjetivoDestruirEquipoAzulNoEstaCumplido(){
    
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(8);// Destruir el ejército Azul de ser imposible 
                                        // al jugador de la derecha
        Juego unJuego = new Juego(4);
        unJuego.iniciarJuegoPrueba();
        unJuego.obtenerJugador(3).establecerObjetivo(obj);
        obj.asignarJugador(unJuego.obtenerJugador(3));

        ArrayList<Pais> paises = unJuego.obtenerTablero().obtenerPaises();

        for (Pais p : paises) {
            if (p.perteneceA(unJuego.obtenerJugador(2))){
                p.cambiarFicha(unJuego.obtenerJugador(2).obtenerFicha());
            }
        }
        
        obj.actualizar(unJuego);                 
        assertFalse(obj.estaCumplido());
    }

    @Test
    public void test05ObjetivoOcuparAfricaEstaCumplido(){
    
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(0);// Ocupar Africa, 5 de A Norte y 4 Europa

        Juego unJuego = new Juego(4);
        unJuego.iniciarJuegoPrueba();
        Jugador unJug = unJuego.obtenerJugador(3);
        unJug.establecerObjetivo(obj);
        obj.asignarJugador(unJug);

        Tablero tablero = unJuego.obtenerTablero();

        for (Pais p : tablero.obtenerPaises()) {
            if (p.continenteNombre().equalsIgnoreCase("Africa") && !p.perteneceA(unJug)){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("America del Norte") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "America Del Norte") < 5 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("Europa") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "Europa") < 4 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
        }
        
        obj.actualizar(unJuego);                 
        assertTrue(obj.estaCumplido());
    }

    @Test
    public void test06ObjetivoOcuparPaisesEstaCumplido(){
    
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(5);// Ocupar 2 países de Oceanía, 2 países de África, 
                                        // 2 países de América del Sur, 3 países de Europa, 
                                        // 4 de América del Norte y 3 de Asia

        Juego unJuego = new Juego(4);
        unJuego.iniciarJuegoPrueba();
        Jugador unJug = unJuego.obtenerJugador(3);
        unJug.establecerObjetivo(obj);
        obj.asignarJugador(unJug);

        Tablero tablero = unJuego.obtenerTablero();

        for (Pais p : tablero.obtenerPaises()) {
            if (p.continenteNombre().equalsIgnoreCase("Oceania") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "Oceania") < 2 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("Africa") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "Africa") < 2 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("America del Sur") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "America del Sur") < 2 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("Europa") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "Europa") < 3 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("America del Norte") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "America Del Norte") < 4 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("Asia") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "Asia") < 3 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
        }
        
        obj.actualizar(unJuego);                 
        assertTrue(obj.estaCumplido());
    }

    @Test
    public void test07ObjetivoOcuparOceaniaYAmericaNEstaCumplido() {
    
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(6);// Ocupar Oceanía, América del Norte y 2 países de Europa

        Juego unJuego = new Juego(4);
        unJuego.iniciarJuegoPrueba();
        Jugador unJug = unJuego.obtenerJugador(3);
        unJug.establecerObjetivo(obj);
        obj.asignarJugador(unJug);

        Tablero tablero = unJuego.obtenerTablero();

        for (Pais p : tablero.obtenerPaises()) {
            if (p.continenteNombre().equalsIgnoreCase("Oceania") && !p.perteneceA(unJug)){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("America del norte") && !p.perteneceA(unJug)){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("Europa") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "Europa") < 2 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
        }
        
        obj.actualizar(unJuego);                 
        assertTrue(obj.estaCumplido());
    }


    
}
