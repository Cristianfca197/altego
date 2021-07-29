package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Etapa.EtapaRAtacar;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.SeleccionarVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FinalizarTurnoEventHandler implements EventHandler<ActionEvent> {
    private final Juego juego;
    private final SeleccionarVista vista;


    public FinalizarTurnoEventHandler(Juego juego, SeleccionarVista seleccionarVista){
        this.juego = juego;
        this.vista = seleccionarVista;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        juego.pasarTurno();
        if (juego.obtenerEtapaR().getClass() == EtapaRAtacar.class) {
            vista.mostrarInterfazAtaque(juego, juego.obtenerJugador(1).obtenerNombre(), juego.obtenerJugador(2).obtenerNombre());
        }
    }
}
