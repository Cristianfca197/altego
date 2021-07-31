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

        Objetivo obj = objetivos.get(8);
        obj.equipoDestruido("Azul");

        assertTrue(obj.estaCumplido());
    }

    @Test
    public void test02ObjetivoDestruirDesapareceEquipoAzulCumplido(){
    
        LecturaArchivoObjetivos leer = new LecturaArchivoObjetivos();
        ArrayList<Objetivo> objetivos = new ArrayList<>();
        leer.leerArchivo(objetivos);

        Objetivo obj = objetivos.get(8);
        obj.equipoDestruido("Azul");

        assertTrue(obj.estaCumplido());
    }


    
}
