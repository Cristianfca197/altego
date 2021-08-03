package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VistaObjetivo extends VBox{

    public VistaObjetivo(Objetivo objetivo, Juego juego, VistaEtapaColocacion vistaColocacion) {

        super();
        Label labelArchivo = new Label("OBJETIVO:");
        labelArchivo.setFont(new Font("Arial", 25));
        labelArchivo.setTextFill(Color.web("#504d4c"));

        Image brujula = new Image("file:" + "multimedia/brujula.png", 200, 200, true, true);
        ImageView imagenVista = new ImageView(brujula);
        Label etiqueta = new Label();
        etiqueta.setText(objetivo.titulo());
        etiqueta.setWrapText(true);
        etiqueta.setTextFill(Color.web("#504d4c"));

        HBox contenedorHorizontal = new HBox(etiqueta, imagenVista);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        contenedorHorizontal.setSpacing(10);

        VBox contenedorPrincipal = new VBox(labelArchivo, contenedorHorizontal);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setPadding(new Insets(25));
        contenedorPrincipal.setStyle("-fx-background-color:#ffffff");
        this.getChildren().add(contenedorPrincipal);
        
    }

}
