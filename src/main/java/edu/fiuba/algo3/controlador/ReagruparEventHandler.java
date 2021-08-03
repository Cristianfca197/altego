package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.SeleccionarVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ReagruparEventHandler  implements EventHandler<ActionEvent> {
    private final Juego juego;
    private final SeleccionarVista vista;

    public ReagruparEventHandler(Juego juego, SeleccionarVista seleccionarVista){
        this.juego = juego;
        this.vista = seleccionarVista;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        juego.pasarTurno();
        this.vista.mostrarInterfazReagrupar(juego, juego.obtenerJugadorActual(), juego.obtenerSiguienteJugador(), juego.obtenerJugadorJugando().color());
    }
}
