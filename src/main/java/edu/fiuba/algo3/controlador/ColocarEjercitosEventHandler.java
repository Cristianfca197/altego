package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaEtapaColocacion;
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
    private final VistaEtapaColocacion vista;


    public ColocarEjercitosEventHandler(TextField textField, Label etiqueta, Stage stage, String nombre, Juego juego, VistaPais pais, VistaEtapaColocacion vista) {
        this.texto = textField;
        this.etiqueta = etiqueta;
        this.stage = stage;
        this.juego = juego;
        this.nombre = nombre;
        this.pais = pais;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(new ValidarTextoEsNumero().validarTexto(this.texto.getText())){
            try{
                juego.colocarEjercitosPaisNombre(nombre, Integer.parseInt(this.texto.getText()));
            } catch (Exception e){
                new Alerta(e.getMessage(), e.getMessage());
            }
            pais.actualizar(juego.obtenerPais(nombre).cantidadDeEjercitos(), juego.obtenerPais(nombre).obtenerFicha().color());
            vista.actualizarVista(juego.obtenerJugadorActual(), juego.obtenerSiguienteJugador(), juego.cantidadEjercitosDisponibles());
        }else{
            new Alerta("No es un número.",texto.getText());
        }

        this.stage.close();

    }
}
