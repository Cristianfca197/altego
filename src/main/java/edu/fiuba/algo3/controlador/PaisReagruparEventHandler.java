package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaEtapaReagrupar;
import edu.fiuba.algo3.vista.VistaPais;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaisReagruparEventHandler implements EventHandler<MouseEvent> {
    private final VistaPais pais;
    private final Juego juego;
    private final VistaEtapaReagrupar vista;

    public PaisReagruparEventHandler(VistaPais pais, VistaEtapaReagrupar vista, Juego juego){
        this.pais = pais;
        this.juego = juego;
        this.vista = vista;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        if(vista.obtenerPaisOrigen() == null){
            vista.paisOrigenElegido(pais);
        }
        else{
            Stage stage = new Stage();
            Label etiqeta = new Label("Ingrese la cantidad de ejercitos a mover");
            TextField textField =  new TextField();
            textField.setText("0");
            Button botonEnviar = new Button("Mover");
            String nombreOrigen = vista.obtenerPaisOrigen().obtenerNombre();
            String nombreDestino = pais.obtenerNombre();
            MoverEjercitosEventHandler moverEjercitosEventHandler = new MoverEjercitosEventHandler(textField, etiqeta, stage, nombreOrigen, nombreDestino, juego, vista, pais);
            botonEnviar.setOnAction(moverEjercitosEventHandler);
            Scene scene = new Scene(new VBox(etiqeta, textField, botonEnviar));
            stage.setScene(scene);
            stage.show();
        }
    }
}
