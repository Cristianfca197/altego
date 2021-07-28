package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaEtapaAtaque extends VBox {
    public VistaEtapaAtaque(Mapa mapa){

        Button botonAtaque = new Button();
        botonAtaque.setText("Atacar");
        botonAtaque.setFont(new Font("Arial",18));
        Button botonReagrupar = new Button();
        botonReagrupar.setText("Reagrupar");
        botonReagrupar.setFont(new Font("Arial",18));
        Button botonObjetivo = new Button();
        botonObjetivo.setText("Ver Objetivo");
        botonObjetivo.setFont(new Font("Arial",18));

        HBox contenedorBotones1 = new HBox(botonAtaque, botonObjetivo, botonReagrupar);
        contenedorBotones1.setSpacing(20);
        contenedorBotones1.setAlignment(Pos.CENTER);


        this.getChildren().addAll(mapa,contenedorBotones1);


    }
}
