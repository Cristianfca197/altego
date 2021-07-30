package edu.fiuba.algo3.modelo.juego;

import javafx.scene.paint.Color;

public class Ficha {
    private Color color;

    public Ficha(){
        this.color = Color.BLUE;
    }
    public boolean esIgualA(Ficha unaFicha){
        return (unaFicha == this);
    }
    public Color color(){
        return this.color;
    }

    public void establecerColor(Color unColor) {
        this.color = unColor;
    }
}
