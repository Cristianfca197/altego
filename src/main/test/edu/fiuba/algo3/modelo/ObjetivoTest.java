package edu.fiuba.algo3.modelo;
 
import edu.fiuba.algo3.modelo.juego.Ficha;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoObjetivos;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ObjetivoTest {

    private ArrayList<Objetivo> objetivos = new ArrayList<Objetivo>();
    private Juego unJuego;

    @BeforeEach
    public void BeforeEach() {

        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        leer.leerArchivo(objetivos);
        unJuego = new Juego(4);
        unJuego.iniciarJuegoPrueba();

    }

    @Test
    public void test01ObjetivoDestruirDesapareceEquipoAzulCumplido(){

        Objetivo obj = objetivos.get(8); // Destruir el ejército azul de ser imposible al jugador de la derecha
        Jugador unJug = unJuego.obtenerJugador(3); 
        unJug.establecerObjetivo(obj);
        obj.asignarJugador(unJug);

        ArrayList<Pais> paises = unJuego.obtenerTablero().obtenerPaises();

        for (Pais p : paises) {
            if (p.perteneceA(unJuego.obtenerJugador(4))){
                p.cambiarFicha(unJuego.obtenerJugador(2).obtenerFicha());
            }
        }

        obj.actualizar(unJuego);

        assertTrue(obj.estaCumplido() && unJuego.objetivoCumplido(unJug));
    }

    @Test
    public void test02ObjetivoDestruirDesapareceEquipoRojoNoExisteCumplido(){

        Objetivo obj = objetivos.get(10); // Destruir el ejército Negro de ser imposible 
                                          // al jugador de la derecha
        Jugador unJug = unJuego.obtenerJugador(3);
        unJug.establecerObjetivo(obj);
        obj.asignarJugador(unJug);

        ArrayList<Pais> paises = unJuego.obtenerTablero().obtenerPaises();

        for (Pais p : paises) {
            if (p.perteneceA(unJuego.obtenerJugador(4))){
                p.cambiarFicha(unJuego.obtenerJugador(2).obtenerFicha());
            }
        }
        
        obj.actualizar(unJuego);                 
        assertTrue(obj.estaCumplido() && unJuego.objetivoCumplido(unJug));
    }

    @Test
    public void test03ObjetivoDestruirEquipoMagentaNoExisteCumplido(){

        Objetivo obj = objetivos.get(13); // Destruir el ejército Negro de ser imposible 
                                          // al jugador de la derecha
        Jugador unJug = unJuego.obtenerJugador(4);
        unJug.establecerObjetivo(obj); // Se lo asigno al ultimo jugador.
        obj.asignarJugador(unJug);     // El siguiente "a la derecha" es el primero.

        ArrayList<Pais> paises = unJuego.obtenerTablero().obtenerPaises();

        for (Pais p : paises) {
            if (p.perteneceA(unJuego.obtenerJugador(1))){
                p.cambiarFicha(unJuego.obtenerJugador(2).obtenerFicha());
            }
        }
        
        obj.actualizar(unJuego);                 
        assertTrue(obj.estaCumplido() && unJuego.objetivoCumplido(unJug));
    }

    @Test
    public void test04ObjetivoDestruirEquipoAzulNoEstaCumplido(){

        Objetivo obj = objetivos.get(8);// Destruir el ejército Azul de ser imposible 
                                        // al jugador de la derecha
        Jugador unJug = unJuego.obtenerJugador(3);
        unJug.establecerObjetivo(obj);
        obj.asignarJugador(unJug);

        ArrayList<Pais> paises = unJuego.obtenerTablero().obtenerPaises();

        for (Pais p : paises) {
            if (p.perteneceA(unJuego.obtenerJugador(2))){
                p.cambiarFicha(unJuego.obtenerJugador(1).obtenerFicha());
            }
        }
        
        obj.actualizar(unJuego);                 
        assertFalse(obj.estaCumplido() || unJuego.objetivoCumplido(unJug));
    }

    @Test
    public void test05ObjetivoOcuparAfricaEstaCumplido(){

        Objetivo obj = objetivos.get(0);// Ocupar Africa, 5 de A Norte y 4 Europa

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
        assertTrue(obj.estaCumplido() && unJuego.objetivoCumplido(unJug));
    }

    @Test
    public void test06ObjetivoOcuparPaisesEstaCumplido(){

        Objetivo obj = objetivos.get(5);// Ocupar 2 países de Oceanía, 2 países de África, 
                                        // 2 países de América del Sur, 3 países de Europa, 
                                        // 4 de América del Norte y 3 de Asia

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
        assertTrue(obj.estaCumplido() && unJuego.objetivoCumplido(unJug));
    }

    @Test
    public void test07ObjetivoOcuparOceaniaYAmericaNEstaCumplido() {

        Objetivo obj = objetivos.get(6);// Ocupar Oceanía, América del Norte y 2 países de Europa

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
        assertTrue(obj.estaCumplido() && unJuego.objetivoCumplido(unJug));
    }

    @Test
    public void test08ObjetivoComunOcupar30PaisesCumplido() {

        Objetivo obj = objetivos.get(2);// Ocupar 30 paisees

        Juego unJuego = new Juego(4);
        unJuego.iniciarJuegoPrueba();
        Jugador unJug = unJuego.obtenerJugador(3);
        unJug.establecerObjetivo(obj);
        obj.asignarJugador(unJug);

        Tablero tablero = unJuego.obtenerTablero();

        int i = 0;

        for (Pais p : tablero.obtenerPaises() ) {
            if(i==30) break;
            if (!p.perteneceA(unJug)){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            i++;
        }

        obj.actualizar(unJuego);                 
        assertTrue(obj.estaCumplido());
    }

    @Test
    public void test09ObjetivoOcuparPaisesNoEstaCumplido(){

        Objetivo obj = objetivos.get(5);// Ocupar 2 países de Oceanía, 2 países de África, 
                                        // 2 países de América del Sur, 3 países de Europa, 
                                        // 4 de América del Norte y 3 de Asia

        Jugador unJug = unJuego.obtenerJugador(3);
        unJug.establecerObjetivo(obj);
        obj.asignarJugador(unJug);

        Tablero tablero = unJuego.obtenerTablero();

        for (Pais p : tablero.obtenerPaises()) {
            if (p.continenteNombre().equalsIgnoreCase("Oceania") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "Oceania") < 1 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("Africa") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "Africa") < 1 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("America del Sur") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "America del Sur") < 1 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("Europa") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "Europa") < 5 ){
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
        assertFalse(obj.estaCumplido() || unJuego.objetivoCumplido(unJug));
    }

    @Test
    public void test10ObjetivosVariosJugadoresGanaElPrimero(){

        Jugador unJug = unJuego.obtenerJugador(1);

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
        
        unJuego.actualizarObjetivos();
        assertTrue(unJuego.obtenerJugador(1).objetivo().estaCumplido() && unJuego.objetivoCumplido(unJuego.obtenerJugador(1)));
        assertFalse(unJuego.obtenerJugador(2).objetivo().estaCumplido() || unJuego.objetivoCumplido(unJuego.obtenerJugador(2)));
        assertFalse(unJuego.obtenerJugador(3).objetivo().estaCumplido() || unJuego.objetivoCumplido(unJuego.obtenerJugador(3)));
        assertFalse(unJuego.obtenerJugador(4).objetivo().estaCumplido() || unJuego.objetivoCumplido(unJuego.obtenerJugador(4)));
    }

    @Test
    public void test11ObjetivosVariosJugadoresGanaElSegundo(){

        Jugador unJug = unJuego.obtenerJugador(2); // Ocupar Asur, Africa y 5 de Anorte

        Tablero tablero = unJuego.obtenerTablero();

        for (Pais p : tablero.obtenerPaises()) {
            if (p.continenteNombre().equalsIgnoreCase("Africa") && !p.perteneceA(unJug)){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("America del sur") && !p.perteneceA(unJug)){
                p.cambiarFicha(unJug.obtenerFicha());
            }
            if (p.continenteNombre().equalsIgnoreCase("America del Norte") && 
                !p.perteneceA(unJug) &&
                tablero.obtenerCantidadPaisesJugadorEnContinente(unJug, "America Del Norte") < 5 ){
                p.cambiarFicha(unJug.obtenerFicha());
            }
        }
        
        unJuego.actualizarObjetivos();
        assertFalse(unJuego.obtenerJugador(1).objetivo().estaCumplido() || unJuego.objetivoCumplido(unJuego.obtenerJugador(1)));
        assertTrue(unJuego.obtenerJugador(2).objetivo().estaCumplido() && unJuego.objetivoCumplido(unJuego.obtenerJugador(2)));
        assertFalse(unJuego.obtenerJugador(3).objetivo().estaCumplido() || unJuego.objetivoCumplido(unJuego.obtenerJugador(3)));
        assertFalse(unJuego.obtenerJugador(4).objetivo().estaCumplido() || unJuego.objetivoCumplido(unJuego.obtenerJugador(4)));
    }

    @Test
    public void test12ObjetivosVariosJugadoresGanaElTercero(){
        // jugador 3 -> destruir equipo rojo, jugador 4 -> destruir derecha
        Tablero tablero = unJuego.obtenerTablero();
        Ficha fichaDesechar = new Ficha();
        for (Pais p : tablero.obtenerPaises()) {
            if (p.perteneceA(unJuego.obtenerJugador(1))){
                p.cambiarFicha(fichaDesechar);
            }
        }
        
        unJuego.actualizarObjetivos();
        assertFalse(unJuego.obtenerJugador(1).objetivo().estaCumplido() || unJuego.objetivoCumplido(unJuego.obtenerJugador(1)));
        assertFalse(unJuego.obtenerJugador(2).objetivo().estaCumplido() || unJuego.objetivoCumplido(unJuego.obtenerJugador(2)));
        assertTrue(unJuego.obtenerJugador(3).objetivo().estaCumplido() && unJuego.objetivoCumplido(unJuego.obtenerJugador(3)));
        assertTrue(unJuego.obtenerJugador(4).objetivo().estaCumplido() && unJuego.objetivoCumplido(unJuego.obtenerJugador(4)));
    }
    

}
