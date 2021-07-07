package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final Ficha ficha;
    private final ArrayList<Pais> paisesPropios;

    public Jugador(){
        this.ficha = new Ficha();
        this.paisesPropios = new ArrayList<>();
    }
    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais){
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
        this.paisesPropios.add(unPais);
    }
    public Ficha obtenerFicha(){
        return this.ficha;
    }

    public void ocuparPais(Pais paisNuevo, int cantidadEjercito) {
        paisNuevo.cambiarFicha(this.obtenerFicha());
        paisNuevo.colocarEjercitos(cantidadEjercito, this.obtenerFicha());
        this.paisesPropios.add(paisNuevo);
    }

}
