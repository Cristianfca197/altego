package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaEtapaReagrupar;
import edu.fiuba.algo3.vista.VistaPais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MoverEjercitosEventHandler implements EventHandler<ActionEvent> {
    private final TextField texto;
    private final Stage stage;
    private final String paisOrigen;
    private final String paisDestino;
    private final Juego juego;
    private final VistaEtapaReagrupar vista;
    private final Label etiqueta;
    private final VistaPais pais;

    public MoverEjercitosEventHandler(TextField textField, Label etiqeta, Stage stage, String nombreOrigen, String nombreDestino, Juego juego, VistaEtapaReagrupar vista, VistaPais pais) {
        this.texto = textField;
        this.etiqueta = etiqeta;
        this.stage = stage;
        this.paisOrigen = nombreOrigen;
        this.paisDestino = nombreDestino;
        this.juego = juego;
        this.vista = vista;
        this.pais = pais;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (new ValidarTextoEsNumero().validarTexto(texto.getText())) {
            this.stage.close();
            juego.transferirEjercitosDeA(paisOrigen, paisDestino, Integer.parseInt(texto.getText()));
            pais.actualizar(juego.obtenerPais(pais.obtenerNombre()).cantidadDeEjercitos(), juego.obtenerPais(pais.obtenerNombre()).obtenerFicha().color());
            vista.obtenerPaisOrigen().actualizar(juego.obtenerPais(vista.obtenerPaisOrigen().obtenerNombre()).cantidadDeEjercitos(), juego.obtenerPais(vista.obtenerPaisOrigen().obtenerNombre()).obtenerFicha().color());
            vista.fichasMovidas();
        }else{
            new Alerta(texto.getText() + " No es un número.", texto.getText());
        }
    }
}
