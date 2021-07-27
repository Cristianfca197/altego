package edu.fiuba.algo3.modelo.juego;

import javafx.scene.paint.Color;

public class Ficha {
    private final Color color;

    public Ficha(){
        this.color = Color.BLUE;
    }
    public boolean esIgualA(Ficha unaFicha){
        return (unaFicha == this);
    }
    public Color color(){
        return this.color;
    }
}
