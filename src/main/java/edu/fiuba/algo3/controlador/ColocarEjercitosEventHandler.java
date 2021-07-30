package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaPais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ColocarEjercitosEventHandler implements EventHandler<ActionEvent> {

    private final TextField texto;
    private final Label etiqueta;
    private final Stage stage;
    private final Juego juego;
    private final String nombre;
    private final VistaPais pais;


    public ColocarEjercitosEventHandler(TextField textField, Label etiqueta, Stage stage, String nombre, Juego juego, VistaPais pais) {
        this.texto = textField;
        this.etiqueta = etiqueta;
        this.stage = stage;
        this.juego = juego;
        this.nombre = nombre;
        this.pais = pais;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.texto.getText().trim().equals("")){
            etiqueta.setText("Ingrese algun numero");
            etiqueta.setFont(new Font("Arial", 12));
            etiqueta.setTextFill(Color.web("#ffd700"));
        }
        this.stage.close();
        juego.colocarEjercitosPaisNombre(nombre, Integer.parseInt(this.texto.getText()));
        pais.actualizar(juego.obtenerPais(nombre).cantidadDeEjercitos(), juego.obtenerPais(nombre).obtenerFicha().color());
    }
}
