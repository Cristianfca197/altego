package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Etapa.EtapaAtacar;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.SeleccionarVista;
import edu.fiuba.algo3.vista.VistaEtapaColocacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FinalizarTurnoEventHandler implements EventHandler<ActionEvent> {
    private final Juego juego;
    private final SeleccionarVista vista;
    private final VistaEtapaColocacion vistaColocacion;


    public FinalizarTurnoEventHandler(Juego juego, SeleccionarVista seleccionarVista, VistaEtapaColocacion vista){
        this.juego = juego;
        this.vista = seleccionarVista;
        this.vistaColocacion = vista;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        juego.pasarTurno();
        vistaColocacion.actualizarVista(juego.obtenerJugadorActual(), juego.obtenerSiguienteJugador(), juego.cantidadEjercitosDisponibles());
        if (juego.obtenerEtapaR().getClass() == EtapaAtacar.class) {
            vista.mostrarInterfazAtaque(juego, juego.obtenerJugadorActual(), juego.obtenerSiguienteJugador());
        }
    }
}
