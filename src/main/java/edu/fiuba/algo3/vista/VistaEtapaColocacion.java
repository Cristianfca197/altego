package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VistaEtapaColocacion extends VBox {
    public VistaEtapaColocacion(){
        Image mapa = new Image("file:" + "multimedia/tableroTEG.png", 900 ,1000, true, true);
        ImageView imagenMapa = new ImageView(mapa);
        imagenMapa.fitWidthProperty();
        Label etiqueta = new Label();
        etiqueta.setText("Cantidad de ejercitos disponibles:");
        etiqueta.setTextFill(Color.BLUE);
        Button botonCanje = new Button();
        botonCanje.setText("Realizar Canje");
        Button botonColocarEjercitos = new Button();
        botonColocarEjercitos.setText("Colocar ejercitos");
        Button botonFinTurno = new Button();
        botonFinTurno.setText("Finalizar Turno");
        Button botonObjetivo = new Button();
        botonObjetivo.setText("Ver Objetivo");
        Button botonTarjetaPais = new Button();
        botonTarjetaPais.setText("Activar Tarjeta");


        HBox contenedorBotones1 = new HBox(etiqueta,botonCanje, botonObjetivo);
        contenedorBotones1.setSpacing(20);
        contenedorBotones1.setAlignment(Pos.CENTER);
        HBox contenedorBotones2 = new HBox(botonColocarEjercitos, botonFinTurno, botonTarjetaPais);
        contenedorBotones2.setSpacing(20);
        contenedorBotones2.setAlignment(Pos.CENTER);
        VBox contenedorPrincipal = new VBox(contenedorBotones1, contenedorBotones2);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

        this.getChildren().addAll(imagenMapa,contenedorPrincipal);


    }
}
