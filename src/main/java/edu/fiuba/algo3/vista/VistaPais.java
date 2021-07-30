package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class VistaPais extends StackPane {

    private final String nombre;

    public VistaPais(int cantidadEjercitos, Paint color, String nombre){
        this.nombre = nombre;
        Label ejercitos = new Label();
        ejercitos.setText(String.valueOf((cantidadEjercitos)));
        Circle ficha = new Circle();
        ficha.setRadius(10);
        ficha.setFill(color);
        this.getChildren().addAll(ficha, ejercitos);
        /*
        PaisSeleccionadoEventHandler paisSeleccionadoEventHandler = new PaisSeleccionadoEventHandler(this);
        this.setOnMouseClicked(paisSeleccionadoEventHandler);
        */

    }
    public String obtenerNombre(){
        return this.nombre;
    }

}
