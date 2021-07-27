package edu.fiuba.algo3.modelo.juego;

import java.util.*;
import javafx.scene.paint.Color;
//import jdk.tools.jlink.resources.plugins;
import edu.fiuba.algo3.modelo.canje.Canje;
import edu.fiuba.algo3.modelo.canje.PrimerCanje;

public class Jugador {
    private Ficha ficha;
    private final MazoTarjetasPais listaTarjetas;
    private Canje canje;
    private String nombre;

    public Jugador() {

//        this.ficha = new Ficha();
        this.listaTarjetas = new MazoTarjetasPais();
        this.canje = new PrimerCanje();
    }

    public void agregarTarjeta(TarjetaPais unaTarjeta) {
        listaTarjetas.agregarTarjeta(unaTarjeta);
    }

    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais) {
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
    }

    public Ficha obtenerFicha() {
        return this.ficha;
    }

    public void colocarEjercitosCanje(Integer cantidadDeEjercitos, Pais pais) {
        pais.colocarEjercitos(cantidadDeEjercitos, this.obtenerFicha());
    }

    public int canjearTarjetas(ArrayList<TarjetaPais> tarjetas) {
        int ejercitosAgregar;
        ejercitosAgregar = canje.realizarCanje(tarjetas);
        this.canje = this.canje.actualizarCanje();
        return ejercitosAgregar;
    }

    public ArrayList<TarjetaPais> ocuparPaises() {
        ArrayList<TarjetaPais> tarjetas = this.listaTarjetas.obtenerTarjetas();
        for (TarjetaPais tarjeta : tarjetas) {
            tarjeta.obtenerPais().asignarJugador(this);
        }
        return tarjetas;
    }

    public void activarTarjetaPais(TarjetaPais unaTarjetaPais) {
        unaTarjetaPais.activarTarjeta(this);
    }

    public boolean tieneFicha(Ficha unaficha) {
        return this.ficha.esIgualA(unaficha);
    }

    public ArrayList<TarjetaPais> obtenerTarjetas() {
        return listaTarjetas.obtenerTarjetas();
    }

    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    public final void establecerColorFicha(Color unColor) {

        this.ficha = new Ficha(unColor);
    }
}
