package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Etapa.EtapaRAtacar;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.SeleccionarVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FInTurnoEventHandler implements EventHandler<ActionEvent> {
    private final Juego juego;
    private final SeleccionarVista seleccionarVista;

    public FInTurnoEventHandler(Juego juego, SeleccionarVista vista) {
        this.juego = juego;
        this.seleccionarVista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.pasarTurno();
        if(juego.obtenerEtapaR().getClass() == EtapaRAtacar.class){
            seleccionarVista.mostrarInterfazAtaque(juego, juego.obtenerJugadorActual(), juego.obtenerSiguienteJugador());
        }
        else {
            seleccionarVista.mostrarInterfazColocacion(juego, juego.obtenerJugadorActual(), juego.obtenerSiguienteJugador(), juego.cantidadEjercitosDisponibles());
        }
    }
}
