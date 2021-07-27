package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.tipoTarjeta.Barco;
import edu.fiuba.algo3.modelo.tipoTarjeta.Canion;
import edu.fiuba.algo3.modelo.tipoTarjeta.Comodin;
import edu.fiuba.algo3.modelo.tipoTarjeta.Globo;
import edu.fiuba.algo3.vista.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        Mapa mapa = new Mapa();
        TarjetaPais tarjetaPais = new TarjetaPais(new Canion(), "Argentina");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Comodin(), "Chile");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Barco(), "Brasil");
        TarjetaPais tarjetaPais4 = new TarjetaPais(new Globo(), "Uruguay");

        ArrayList<TarjetaPais> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaPais);
        tarjetas.add(tarjetaPais2);
        tarjetas.add(tarjetaPais3);
        tarjetas.add(tarjetaPais4);

        VistaTarjetaPais vistaTarjeta = new VistaTarjetaPais(tarjetas);

        VistaInicial vistaInicial = new VistaInicial();
        VistaEtapaColocacion vistaColocacion = new VistaEtapaColocacion(mapaJuego);
        VistaEtapaAtaque vistaAtaque = new VistaEtapaAtaque(mapa);

        Scene escenaBienvenidos = new Scene (vistaInicial,1000,800);
        Scene escenaColocacion = new Scene(vistaColocacion,1000,800);
        Scene escenaAtaque = new Scene(vistaAtaque,1000,800);
        Scene escenaTarjeta = new Scene(vistaTarjeta, 1000,800);

        stage.setScene(escenaBienvenidos);
        stage.setScene(escenaColocacion);
        stage.setScene(escenaAtaque);
        stage.setScene(escenaTarjeta);
        stage.setResizable(false);

    }
    public static void main(String[] args) {
        launch();
    }

}