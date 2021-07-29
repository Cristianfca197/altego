package edu.fiuba.algo3;


import edu.fiuba.algo3.vista.SeleccionarVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private SeleccionarVista vista;

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
        this.stage = stage;
        this.vista = new SeleccionarVista(this.stage);
        vista.mostrarInterfazInicial();
        //this.mostrarInterfazColocacion();
        //this.mostrarInterfazAtaque();
       // this.mostrarInterfazTarjetas();
    }


    public static void main(String[] args) {
        launch();
    }

}