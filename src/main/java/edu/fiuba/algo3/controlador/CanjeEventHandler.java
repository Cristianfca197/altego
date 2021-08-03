package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaEtapaColocacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class CanjeEventHandler implements EventHandler<ActionEvent> {
    private final Juego juego;
    private final ArrayList<String> tarjetas;
    private final VistaEtapaColocacion vistaColocacion;

    public CanjeEventHandler(Juego juego, ArrayList<String> tarjetas, VistaEtapaColocacion vistaColocacion){
        this.juego = juego;
        this.tarjetas = tarjetas;
        this.vistaColocacion = vistaColocacion;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            juego.realizarCanje(tarjetas);
        } catch (Exception e){
            new Alerta(e.getMessage(), "Canje Invalido");
        }
        this.vistaColocacion.actualizarVista(juego.obtenerJugadorActual(), juego.obtenerSiguienteJugador(), juego.cantidadEjercitosDisponibles());

    }
}
