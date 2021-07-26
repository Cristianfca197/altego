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
        this.mostrarInterfazInicial(stage);
        //this.mostrarInterfazColocacion(stage);
        //this.mostrarInterfazAtaque(stage);
        //this.mostrarInterfazTarjetas(stage);
    }

    public void mostrarInterfazInicial(Stage stage){
        stage.setTitle("Interfaz inicial");
        VistaInicial vistaInicial = new VistaInicial();
        Scene escenaBienvenidos = new Scene (vistaInicial, 1000, 800);
        stage.setScene(escenaBienvenidos);
        stage.setResizable(false);
    }
    public void mostrarInterfazColocacion(Stage stage){
        stage.setTitle("Interfaz Colocacion");
        Mapa mapaJuego = new Mapa();
        VistaEtapaColocacion vistaColocacion = new VistaEtapaColocacion(mapaJuego);
        Scene escenaColocacion = new Scene(vistaColocacion, 1000, 800);
        stage.setScene(escenaColocacion);
        stage.setResizable(false);

    }
    public void mostrarInterfazAtaque(Stage stage){
        stage.setTitle("Interfaz ataque");
        Mapa mapaJuego = new Mapa();
        VistaEtapaAtaque vistaAtaque = new VistaEtapaAtaque(mapaJuego);
        Scene escenaAtaque = new Scene(vistaAtaque, 1000, 800);
        stage.setScene(escenaAtaque);
        stage.setResizable(false);

    }

    public void mostrarInterfazTarjetas(Stage stage){
        stage.setTitle("Interfaz Tarjetas");
        TarjetaPais tarjetaPais = new TarjetaPais(new Canion(), "Argentina");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Comodin(), "Chile");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Barco(), "Brasil");
        TarjetaPais tarjetaPais4 = new TarjetaPais(new Globo(), "Urugauy");

        ArrayList<TarjetaPais> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaPais);
        tarjetas.add(tarjetaPais2);
        tarjetas.add(tarjetaPais3);
        tarjetas.add(tarjetaPais4);

        VistaTarjetaPais vistaTarjeta = new VistaTarjetaPais(tarjetas);

        Scene escenaTarjeta = new Scene(vistaTarjeta, 1000,800);
        stage.setScene(escenaTarjeta);
        stage.setResizable(false);
    }


    public static void main(String[] args) {
        launch();
    }

}