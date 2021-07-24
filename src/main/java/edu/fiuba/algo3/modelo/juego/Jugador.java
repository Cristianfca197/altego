package edu.fiuba.algo3.modelo.juego;

import java.util.*;

import edu.fiuba.algo3.modelo.canje.Canje;
import edu.fiuba.algo3.modelo.canje.PrimerCanje;
import edu.fiuba.algo3.modelo.exception.ExcepcionActivacionTarjetaInvalido;
import edu.fiuba.algo3.modelo.exception.ExcepcionAtaqueInvalido;
import edu.fiuba.algo3.modelo.exception.ExcepcionCanjeInvalido;

public class Jugador {
    private final Ficha ficha;
    private final MazoTarjetasPais listaTarjetas;
    private Canje canje;

    public Jugador() {

        this.ficha = new Ficha();
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

    public int canjearTarjetas(ArrayList<TarjetaPais> tarjetas) {//version seleccion manual
        int ejercitosAgregar = 0;
        ejercitosAgregar = canje.realizarCanje(tarjetas);
        this.canje = this.canje.actualizarCanje();
        return ejercitosAgregar;
    }

    public ArrayList<TarjetaPais> ocuparPaises() {
        ArrayList<TarjetaPais> tarjetas = this.listaTarjetas.obtenerTarjetas();
        for (int i = 0; i < tarjetas.size(); i++) {
            tarjetas.get(i).obtenerPais().asignarJugador(this);
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
}
