package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.Mapa;
import edu.fiuba.algo3.vista.VistaEtapaAtaque;
import edu.fiuba.algo3.vista.VistaEtapaColocacion;
import edu.fiuba.algo3.vista.VistaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
        this.mostrarInterfazColocacion(stage);
    }

    public void mostrarInterfazColocacion(Stage stage){

        stage.setTitle("ALTEGO");


        Mapa mapaJuego = new Mapa();
        VistaInicial vistaInicial = new VistaInicial();
        VistaEtapaColocacion vistaColocacion = new VistaEtapaColocacion(mapaJuego);
        VistaEtapaAtaque vistaAtaque = new VistaEtapaAtaque(mapaJuego);
        Scene escenaBienvenidos = new Scene (vistaInicial);
        Scene escenaColocacion = new Scene(vistaColocacion);
        Scene escenaAtaque = new Scene(vistaAtaque);

      //  stage.setScene(escenaBienvenidos);
       //stage.setScene(escenaColocacion);
        stage.setScene(escenaAtaque);
        stage.setResizable(false);

    }
    public static void main(String[] args) {
        launch();
    }

}