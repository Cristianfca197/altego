package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class JugarEventHandler implements EventHandler<ActionEvent> {
    private final App app;
    private Label label;
    private TextField texto;

    public JugarEventHandler(TextField textField, Label label, App app) {
        this.texto = textField;
        this.label = label;
        this.app = app;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.texto.getText().trim().equals("")){
            label.setText("Cantidad de jugadores invalida");
            label.setFont(new Font("Arial", 12));
            label.setTextFill(Color.web("#ffd700"));
        }
        int cantidadIngresada = Integer.parseInt(texto.getText());
        if( (cantidadIngresada > 1) && (cantidadIngresada < 7)){
            System.out.println(cantidadIngresada);
            Juego juego = new Juego(cantidadIngresada);
            juego.iniciarJuego();
            juego.jugar();
            app.mostrarInterfazColocacion(juego, juego.obtenerJugador(1).obtenerNombre(), juego.obtenerJugador(2).obtenerNombre());

        }
        else {
            label.setText("Cantidad de jugadores invalida");
            label.setFont(new Font("Arial", 12));
            label.setTextFill(Color.web("#ffd700"));
        }

    }
}
