package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class VistaPais extends StackPane {

    private final String nombre;
    private final Label texto;
    private final Circle ficha;

    public VistaPais(int cantidadEjercitos, Paint color, String nombre){
        this.nombre = nombre;
        Label ejercitos = new Label();
        ejercitos.setText(String.valueOf((cantidadEjercitos)));
        Circle ficha = new Circle();
        ficha.setRadius(10);
        ficha.setFill(color);
        this.texto = ejercitos;
        this.ficha = ficha;
        this.getChildren().addAll(ficha, ejercitos);
    }
    public void actualizar(int cantidadEjercitos, Paint color){
        this.texto.setText(String.valueOf(cantidadEjercitos));
        this.ficha.setFill(color);
    }
    public String obtenerNombre(){
        return this.nombre;
    }

}
