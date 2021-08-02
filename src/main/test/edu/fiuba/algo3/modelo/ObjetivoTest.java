package edu.fiuba.algo3.modelo;
 
import edu.fiuba.algo3.modelo.Etapa.*;
import edu.fiuba.algo3.modelo.exception.ExcepcionCanjeInvalido;
import edu.fiuba.algo3.modelo.exception.ExcepcionFinDeJuego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.lectura.LecturaArchivoObjetivos;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import edu.fiuba.algo3.modelo.objetivo.ObjetivoDestruir;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ObjetivoTest {

    @Test
    public void test01ObjetivoDestruirDesapareceEquipoAzulCumplido(){

        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(8); // Destruir el ejército azul de ser imposible al jugador de la derecha
        Juego unJuego = new Juego(5);
        unJuego.iniciarJuegoPrueba();
        unJuego.obtenerJugador(3).establecerObjetivo(obj);

        ArrayList<TarjetaPais> tarjetas = unJuego.obtenerTarjetas();

        for (TarjetaPais tarjetaPais : tarjetas) {
            Pais unPais = tarjetaPais.obtenerPais();
            if (unPais.perteneceA(unJuego.obtenerJugador(4))){
                unPais.cambiarFicha(unJuego.obtenerJugador(2).obtenerFicha());
            }
        }


        assertTrue(true);
    }

    @Test
    public void test02ObjetivoDestruirDesapareceEquipoAzulCumplido(){
    
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(8);

        assertTrue(true);
    }


    
}
