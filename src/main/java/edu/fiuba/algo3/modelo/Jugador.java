package edu.fiuba.algo3.modelo;

public class Jugador {
    private final Ficha ficha;

    public Jugador(){
        this.ficha = new Ficha();
    }
    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais){
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
    }
    public Ficha obtenerFicha(){
        return this.ficha;
    }
}
