package edu.fiuba.algo3;

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



        VistaInicial vistaInicial = new VistaInicial();
        Scene escenaBienvenidos = new Scene (vistaInicial);


        stage.setScene(escenaBienvenidos);
        stage.setResizable(false);
/*
        Label etiqueta = new Label();
        etiqueta.setText("Cantidad de ejercitos disponibles:");
        etiqueta.setTextFill(Color.BLUE);
        Button botonCanje = new Button();
        botonCanje.setText("Realizar Canje");
        Button botonColocarEjercitos = new Button();
        botonColocarEjercitos.setText("Colocar ejercitos");
        Button botonFinTurno = new Button();
        botonFinTurno.setText("Finalizar Turno");
        Button botonObjetivo = new Button();
        botonObjetivo.setText("Ver Objetivo");
        Button botonTarjetaPais = new Button();
        botonTarjetaPais.setText("Activar Tarjeta");


        HBox contenedorBotones1 = new HBox(etiqueta,botonCanje, botonObjetivo);
        contenedorBotones1.setSpacing(10);
        HBox contenedorBotones2 = new HBox(botonColocarEjercitos, botonFinTurno, botonTarjetaPais);
        contenedorBotones2.setSpacing(10);
        VBox contenedorPrincipal = new VBox(contenedorBotones1, contenedorBotones2);
        contenedorPrincipal.setSpacing(10);
        contenedorPrincipal.setPadding(new Insets(20));

        contenedorPrincipal.setLayoutX(0);
        contenedorPrincipal.setLayoutY(600);

        var scene = new Scene((contenedorPrincipal), 1080, 700);

        stage.setScene(scene);
        stage.show();
        */

    }
    public static void main(String[] args) {
        launch();
    }

}