package edu.fiuba.algo3.vista;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VistaEtapaColocacion extends StackPane {
    public VistaEtapaColocacion(Mapa mapa){
        HBox datosTurno = this.datosTurno();
        VBox contenedorBotones1 = this.botonesJugador();
        HBox contenedorBotones2 = this.botonesTurno();
        BorderPane contenedor = new BorderPane();
        contenedor.setTop(datosTurno);
        contenedor.setRight(contenedorBotones1);
        contenedor.setBottom(contenedorBotones2);
        contenedor.setLayoutY(10);
        contenedor.setMargin(datosTurno, new Insets(0, 0, 0, 400));
        contenedor.setMargin(contenedorBotones1, new Insets(200, 0, 0, 0));
        contenedor.setMargin(contenedorBotones2, new Insets(0, 0, 0, 300));
        ObservableList lista = this.getChildren();
        lista.addAll(mapa, contenedor);
        this.setStyle("-fx-background-color: #504d4c");
        this.setMargin(mapa, new Insets(15,50,0,50));
    }

    private HBox botonesTurno() {
        Button botonFinTurno = new Button();
        botonFinTurno.setText("Finalizar Turno");
        Button botonObjetivo = new Button();
        botonObjetivo.setText("Ver Objetivo");
        Button botonTarjetaPais = new Button();
        botonTarjetaPais.setText("Activar Tarjeta");
        HBox contenedor = new HBox(botonFinTurno, botonObjetivo, botonTarjetaPais);
        contenedor.setSpacing(20);
        return contenedor;
    }

    private VBox botonesJugador() {
        Button botonCanje = new Button();
        botonCanje.setText("Realizar Canje");
        Button botonColocarEjercitos = new Button();
        botonColocarEjercitos.setText("Colocar ejercitos");
        VBox contenedor = new VBox( botonCanje, botonColocarEjercitos);
        contenedor.setSpacing(20);
        return contenedor;
    }

    private HBox datosTurno() {
        Label datoJugador = new Label();
        datoJugador.setText("Jugador:");
        datoJugador.setTextFill(Color.WHITE);
        Label proximoJugador = new Label();
        proximoJugador.setText("Siguiente jugador:");
        proximoJugador.setTextFill(Color.WHITE);
        HBox datosTurno = new HBox(datoJugador, proximoJugador);
        datosTurno.setSpacing(20);
        return datosTurno;
    }
}
