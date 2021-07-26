package edu.fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Formas extends Application {
    @Override
    public void start(Stage stage) {

        Polygon dibujoPais = new Polygon();

        dibujoPais.getPoints().addAll(new Double[]{
                200.0, 50.0,
                400.0, 50.0,
                450.0, 150.0,
                400.0, 250.0,
                200.0, 250.0,
                150.0, 150.0,
        });

        Button otroboton = new Button();
        otroboton.setShape(dibujoPais);

    }

}
