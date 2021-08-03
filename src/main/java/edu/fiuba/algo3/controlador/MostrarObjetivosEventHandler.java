package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.SeleccionarVista;
import edu.fiuba.algo3.vista.VistaEtapaColocacion;
import edu.fiuba.algo3.vista.VistaPais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.HashMap;

public class MostrarObjetivosEventHandler implements EventHandler<ActionEvent> {

    private final SeleccionarVista vista;
    private final Juego juego;
    private final HashMap<String, VistaPais> paises;
    private final VistaEtapaColocacion vistaColocacion;

    public MostrarObjetivosEventHandler(SeleccionarVista vista, Juego juego, HashMap<String, VistaPais> stringVistaPaisHashMap, VistaEtapaColocacion vistaEtapaColocacion){
        this.vista = vista;
        this.juego = juego;
        this.paises = stringVistaPaisHashMap;
        this.vistaColocacion = vistaEtapaColocacion;
    }
    
    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = new Stage();
        vista.mostrarInterfazObjetivos(juego, stage, paises, vistaColocacion);

    }
}