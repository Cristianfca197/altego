package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.SeleccionarVista;
import edu.fiuba.algo3.vista.VistaEtapaColocacion;
import edu.fiuba.algo3.vista.VistaPais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.HashMap;

public class MostrarTarjetasEventHandler implements EventHandler<ActionEvent> {

    private final SeleccionarVista vista;
    private final Juego juego;
    private final HashMap<String, VistaPais> paises;
    private final VistaEtapaColocacion vistaColocacion;
    private final boolean esCanje;

    public MostrarTarjetasEventHandler(SeleccionarVista vista, Juego juego, HashMap<String, VistaPais> stringVistaPaisHashMap, VistaEtapaColocacion vistaEtapaColocacion, boolean esCanje){
        this.vista = vista;
        this.juego = juego;
        this.paises = stringVistaPaisHashMap;
        this.vistaColocacion = vistaEtapaColocacion;
        this.esCanje = esCanje;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = new Stage();
        vista.mostrarInterfazTarjetas(juego, stage, paises, esCanje, vistaColocacion);

    }
}
