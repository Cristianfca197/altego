package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class Jugador {
    private final Ficha ficha;
    private final TarjetasPais listaTarjetas;

    public Jugador(){
        this.ficha = new Ficha();
        this.listaTarjetas = new TarjetasPais();
    }

    public void obtenerTarjeta(TarjetaPais unaTarjeta){
        listaTarjetas.agregarTarjeta(unaTarjeta);
    }

    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais){
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
    }
    public Ficha obtenerFicha(){
        return this.ficha;
    }

}
