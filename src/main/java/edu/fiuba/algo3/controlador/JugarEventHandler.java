package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.SeleccionarVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class JugarEventHandler implements EventHandler<ActionEvent> {

    private final SeleccionarVista vista;
    private Label label;
    private TextField texto;

    public JugarEventHandler(TextField textField, Label label, SeleccionarVista seleccionarVista) {
        this.texto = textField;
        this.label = label;
        this.vista = seleccionarVista;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
       if( new ValidarTextoEsNumero().validarTexto(texto.getText())) {
           int cantidadIngresada = Integer.parseInt(texto.getText());

           if ((cantidadIngresada > 1) && (cantidadIngresada < 7)) {
               Juego juego = new Juego(cantidadIngresada);
               juego.jugar();
               this.vista.mostrarInterfazColocacion(juego, juego.obtenerJugadorActual(), juego.obtenerSiguienteJugador(), juego.obtenerJugadorJugando().color(), juego.cantidadEjercitosDisponibles());

           } else {
               new Alerta("ingrese un número del 2 al 6.", texto.getText());
           }
       }else {
           new Alerta("No es un número.",texto.getText());
       }
    }




}
