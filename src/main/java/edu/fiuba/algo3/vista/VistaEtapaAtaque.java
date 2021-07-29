package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class VistaEtapaAtaque extends StackPane {
    public VistaEtapaAtaque(Mapa mapa, String nombreJugadorActual, String nombreSiguienteJugador, Juego juego, App app){
        HBox datosTurno = this.datosTurno(nombreJugadorActual, nombreSiguienteJugador);
        HBox contenedorBotones2 = this.botonesTurno(juego, app);
        BorderPane contenedor = new BorderPane();
        contenedor.setTop(datosTurno);
        contenedor.setBottom(contenedorBotones2);
        contenedor.setLayoutY(10);
        BorderPane.setMargin(datosTurno, new Insets(0, 0, 0, 400));
        BorderPane.setMargin(contenedorBotones2, new Insets(0, 0, 0, 300));
        ObservableList lista = this.getChildren();
        lista.addAll(mapa, contenedor);
        this.setStyle("-fx-background-color: #504d4c");
        setMargin(mapa, new Insets(15,50,0,50));
    }

    private HBox botonesTurno(Juego juego, App app) {
        Button botonReagrupar = new Button();
        botonReagrupar.setText("Reagrupar");
        Button botonObjetivo = new Button();
        botonObjetivo.setText("Ver Objetivo");
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        HBox contenedor = new HBox(botonReagrupar, botonObjetivo, botonAtacar);
        contenedor.setSpacing(20);
        return contenedor;
    }


    private HBox datosTurno(String nombreJugadorActual, String nombreSiguienteJugador) {
        Label datoJugador = new Label();
        datoJugador.setText("Jugador:"+ nombreJugadorActual);
        datoJugador.setTextFill(Color.WHITE);
        Label proximoJugador = new Label();
        proximoJugador.setText("Siguiente jugador:"+ nombreSiguienteJugador);
        proximoJugador.setTextFill(Color.WHITE);
        HBox datosTurno = new HBox(datoJugador, proximoJugador);
        datosTurno.setSpacing(20);
        return datosTurno;
    }

}
