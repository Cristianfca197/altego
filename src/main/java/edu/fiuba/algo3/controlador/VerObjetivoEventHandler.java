package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaObjtetivo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VerObjetivoEventHandler implements EventHandler<ActionEvent> {
    private final Juego juego;

    public VerObjetivoEventHandler(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setTitle("Objetivo");

        VistaObjtetivo vistaObjtetivo = new VistaObjtetivo(juego.obtenerJugadorJugando().objetivo().titulo());
        Scene escenaObtetivo = new Scene(vistaObjtetivo);
        stage.setScene(escenaObtetivo);
        stage.show();
    }
}
