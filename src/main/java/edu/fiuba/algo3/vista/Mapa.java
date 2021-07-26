package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Mapa extends Pane {
    public Mapa(){
        Image mapa = new Image("file:" + "multimedia/tableroTEG.png", 900 ,1000, true, true);
        ImageView imagenMapa = new ImageView(mapa);

        Label cantidadEjercitos = new Label();
        cantidadEjercitos.setText("2");
        Circle ficha = new Circle();
        ficha.setRadius(10);
        ficha.setFill(Color.WHITE);
        StackPane ejercito = new StackPane(ficha, cantidadEjercitos);
        ejercito.setLayoutX(30);
        ejercito.setLayoutY(240);

        Circle otraFicha = new Circle();
        otraFicha.setRadius(10);
        otraFicha.setFill(Color.BLUE);
        otraFicha.setCenterX(80);
        otraFicha.setCenterY(200);

        Pane panePrinciapal = new Pane(imagenMapa, ejercito, otraFicha);
        panePrinciapal.setPadding(new Insets(20));

        this.getChildren().add(panePrinciapal);
    }
}
