package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VistaEtapaColocacion extends VBox {
    public VistaEtapaColocacion(Mapa mapa){
        Label datoJugador = new Label();
        datoJugador.setText("Jugador:");
        datoJugador.setTextFill(Color.BLUE);
        Label proximoJugador = new Label();
        proximoJugador.setText("Siguiente jugador:");
        proximoJugador.setTextFill(Color.BLUE);
        HBox datosTurno = new HBox(datoJugador, proximoJugador);
        datosTurno.setSpacing(20);
        datoJugador.setLayoutX(0);
        datosTurno.setLayoutY(0);

        mapa.setLayoutY(20);

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
        contenedorBotones1.setSpacing(20);
        contenedorBotones1.setLayoutX(0);
        contenedorBotones1.setLayoutY(670);
        HBox contenedorBotones2 = new HBox(botonColocarEjercitos, botonFinTurno, botonTarjetaPais);
        contenedorBotones2.setSpacing(20);
        contenedorBotones2.setLayoutX(0);
        contenedorBotones2.setLayoutY(700);

        Pane panePrinciapal = new Pane(datosTurno,mapa,contenedorBotones1, contenedorBotones2);
        panePrinciapal.setPadding(new Insets(20));


        this.getChildren().addAll(panePrinciapal);


    }
}
