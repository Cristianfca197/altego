package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.controlador.CantidadDeJugadoresEventHandler;
import edu.fiuba.algo3.controlador.JugarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VistaInicial extends VBox{
    public VistaInicial(App app) {
        super();
        Label labelArchivo = new Label("Bienvenido a A.L.T.E.G.O.");
        labelArchivo.setFont(new Font("Arial", 18));
        labelArchivo.setTextFill(Color.web("#ffd700"));

        Image logo = new Image("file:" + "multimedia/logoTEG.jpg", 200, 200, true, true);
        ImageView imagenVista = new ImageView(logo);

        TextField texto = new TextField();
        texto.setPromptText("Ingrese la cantidad de jugadores");
        Label etiqueta = new Label();

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setStyle("-fx-background-color:#27AE60;" +
                "-fx-font-size: 18;" +
                "-fx-font-famiy: sans-serif;"
        );
        JugarEventHandler botonJugarEventHandler = new JugarEventHandler(texto, etiqueta, app);
        botonJugar.setOnAction(botonJugarEventHandler);
        CantidadDeJugadoresEventHandler cantidadDeJugadoresEventHandler = new CantidadDeJugadoresEventHandler(botonJugar);
        texto.setOnKeyPressed(cantidadDeJugadoresEventHandler);

        HBox contenedorHorizontal = new HBox(botonJugar);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        HBox contenedor = new HBox(etiqueta);
        contenedor.setAlignment(Pos.CENTER);

        VBox contenedorPrincipal = new VBox(labelArchivo, imagenVista, texto, contenedorHorizontal, contenedor);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setPadding(new Insets(25));
        contenedorPrincipal.setStyle("-fx-background-color:#504d4c");
        this.getChildren().add(contenedorPrincipal);

    }
}
