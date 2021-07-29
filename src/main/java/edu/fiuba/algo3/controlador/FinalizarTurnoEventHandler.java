package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Etapa.EtapaRAtacar;
import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FinalizarTurnoEventHandler implements EventHandler<ActionEvent> {
    private final Juego juego;
    private final App app;

    public FinalizarTurnoEventHandler(Juego juego, App app){
        this.juego = juego;
        this.app = app;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        juego.pasarTurno();
        if (juego.obtenerEtapaR().getClass() == EtapaRAtacar.class) {
            app.mostrarInterfazAtaque(juego, juego.obtenerJugador(1).obtenerNombre(), juego.obtenerJugador(2).obtenerNombre());
        }
    }
}
