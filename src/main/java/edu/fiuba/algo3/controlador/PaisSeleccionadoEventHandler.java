package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaEtapaColocacion;
import edu.fiuba.algo3.vista.VistaPais;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PaisSeleccionadoEventHandler implements EventHandler<MouseEvent> {

    private final VistaPais pais;
    private final Juego juego;
    private final VistaEtapaColocacion vista;

    public PaisSeleccionadoEventHandler(VistaPais vistaPais, Juego juego, VistaEtapaColocacion vista) {
        this.pais = vistaPais;
        this.juego = juego;
        this.vista = vista;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        String nombre = pais.obtenerNombre();
        Stage stage = new Stage();
        Label etiqeta = new Label("Ingrese la cantidad de ejercitos");
        TextField textField =  new TextField();
        Button botonEnviar = new Button("Colocar");
        ColocarEjercitosEventHandler colocarEjercitosEventHandler = new ColocarEjercitosEventHandler(textField, etiqeta, stage, nombre, juego, this.pais, vista);
        botonEnviar.setOnAction(colocarEjercitosEventHandler);
        Scene scene = new Scene(new VBox(etiqeta, textField, botonEnviar));
        stage.setScene(scene);
        stage.show();

    }

}
