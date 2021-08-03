package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.SeleccionarVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class InicioEventHandler implements EventHandler<ActionEvent> {
    private final ArrayList<TextField> nombres;
    private final SeleccionarVista vista;
    private final Juego juego;

    public InicioEventHandler(Juego juego, SeleccionarVista seleccionarVista, ArrayList<TextField> nombres) {
        this.juego = juego;
        this.vista = seleccionarVista;
        this.nombres = nombres;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<String> nombresJugadores = new ArrayList<>();
        for(TextField nombre: nombres){
            nombresJugadores.add(nombre.getText());
            if(nombre.getText().trim().equals("")){
                new Alerta("Debe ingresar algun nombre", nombre.getText());
                System.out.println("afjeujgiua");
                return;
            }
        }

        juego.jugar(nombresJugadores);
        vista.mostrarInterfazColocacion(juego, juego.obtenerJugadorActual(), juego.obtenerSiguienteJugador(), juego.obtenerJugadorJugando().color(), juego.cantidadEjercitosDisponibles());
    }
}
