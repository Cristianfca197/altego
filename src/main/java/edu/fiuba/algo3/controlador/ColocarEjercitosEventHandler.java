package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaEtapaColocacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ColocarEjercitosEventHandler implements EventHandler<ActionEvent> {
    private final VistaEtapaColocacion vista;

    public ColocarEjercitosEventHandler(VistaEtapaColocacion vistaEtapaColocacion) {
        this.vista = vistaEtapaColocacion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("aaa");
        vista.mostrarAgregarEjercitos();
    }
}
