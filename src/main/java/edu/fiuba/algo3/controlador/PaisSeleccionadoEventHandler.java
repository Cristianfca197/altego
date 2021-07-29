package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaPais;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PaisSeleccionadoEventHandler implements EventHandler<MouseEvent> {

    private final VistaPais pais;

    public PaisSeleccionadoEventHandler(VistaPais vistaPais) {
        System.out.println("Abc");
        this.pais = vistaPais;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAfytfhytfuyAAAA");
        String nombre = pais.obtenerNombre();
        Stage stage = new Stage();
        Scene scene = new Scene(new VBox());
        stage.setScene(scene);

    }

}
