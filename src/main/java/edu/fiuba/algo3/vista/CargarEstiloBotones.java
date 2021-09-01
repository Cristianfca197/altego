package edu.fiuba.algo3.vista;

public class CargarEstiloBotones {

    final String color;

    public CargarEstiloBotones(String unColor){
        this.color = unColor;
    }

    public String ObtenerEstilo(){
        return "-fx-background-color:" + this.color + ";" +
                "-fx-font-size: 18;" +
                "-fx-font-famiy: sans-serif;";
    }
}
