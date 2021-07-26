package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaInicial extends VBox{
    public VistaInicial() {
        super();
        Label labelArchivo = new Label("Bienvenido a A.L.T.E.G.O.");
        labelArchivo.setFont(new Font("Arial", 18));

        Image logo = new Image("file:" + "multimedia/logoTEG.jpg", 650, 500, true, true);
        ImageView imagenVista = new ImageView(logo);

        TextField texto = new TextField();
        texto.setPromptText("Ingrese la cantidad de jugadores");

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");

        Button botonLimpiar = new Button();
        botonLimpiar.setText("Limpiar cuadro texto");

        HBox contenedorHorizontal = new HBox(botonEnviar, botonLimpiar);
        contenedorHorizontal.setSpacing(10);

        VBox contenedorPrincipal = new VBox(labelArchivo, imagenVista, texto, contenedorHorizontal);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setPadding(new Insets(25));

        this.getChildren().add(contenedorPrincipal);

    }
}
