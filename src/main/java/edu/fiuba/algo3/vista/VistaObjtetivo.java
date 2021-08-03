package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaObjtetivo extends VBox {

    public VistaObjtetivo(String titulo) {
        Label label = new Label(titulo);
        this.getChildren().add(label);
    }


}
