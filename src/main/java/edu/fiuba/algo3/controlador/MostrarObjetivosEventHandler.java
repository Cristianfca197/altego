package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.SeleccionarVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class MostrarObjetivosEventHandler implements EventHandler<ActionEvent> {

    private final SeleccionarVista vista;
    private final Juego juego;


    public MostrarObjetivosEventHandler(SeleccionarVista vista, Juego juego){
        this.vista = vista;
        this.juego = juego;
    }
    
    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = new Stage();
        vista.mostrarInterfazObjetivos(juego, stage);

    }
}