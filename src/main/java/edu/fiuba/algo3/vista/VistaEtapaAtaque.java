package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaEtapaAtaque extends VBox {
    public VistaEtapaAtaque(){
        Image mapa = new Image("file:" + "multimedia/tableroTEG.png", 900 ,1000, true, true);
        ImageView imagenMapa = new ImageView(mapa);
        imagenMapa.fitWidthProperty();

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


        this.getChildren().addAll(imagenMapa,contenedorBotones1);


    }
}
