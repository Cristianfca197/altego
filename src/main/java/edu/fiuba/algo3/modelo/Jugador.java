package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class Jugador {
    private final Ficha ficha;
    private final ArrayList<TarjetaPais> listaTarjetas;

    public Jugador(){
        this.ficha = new Ficha();
        this.listaTarjetas = new ArrayList<>();
    }

    public void obtenerTarjeta(TarjetaPais unaTarjeta){
        listaTarjetas.add(unaTarjeta);
    }

    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais){
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
    }


    public Ficha obtenerFicha(){
        return this.ficha;
    }



}
