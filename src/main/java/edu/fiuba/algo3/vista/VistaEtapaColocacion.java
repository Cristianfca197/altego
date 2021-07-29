package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ColocarEjercitosEventHandler;
import edu.fiuba.algo3.controlador.FinalizarTurnoEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VistaEtapaColocacion extends StackPane {
    private final BorderPane contenedor;
    private final SeleccionarVista vista;

    public VistaEtapaColocacion(Mapa mapa, String nombreJugadorActual, String nombreSiguienteJugador, Juego juego, SeleccionarVista seleccionarVista){
        this.vista = seleccionarVista;
        HBox datosTurno = this.datosTurno(nombreJugadorActual, nombreSiguienteJugador);
        VBox contenedorBotones1 = this.botonesJugador();
        HBox contenedorBotones2 = this.botonesTurno(juego);
        BorderPane contenedor = new BorderPane();
        this.contenedor = contenedor;
        contenedor.setTop(datosTurno);
        contenedor.setRight(contenedorBotones1);
        contenedor.setBottom(contenedorBotones2);
        contenedor.setLayoutY(10);
        BorderPane.setMargin(datosTurno, new Insets(0, 0, 0, 400));
        BorderPane.setMargin(contenedorBotones1, new Insets(200, 0, 0, 0));
        BorderPane.setMargin(contenedorBotones2, new Insets(0, 0, 0, 300));
        ObservableList lista = this.getChildren();
        lista.addAll(mapa, contenedor);
        this.setStyle("-fx-background-color: #504d4c");
        setMargin(mapa, new Insets(15,50,0,50));
    }

    private HBox botonesTurno(Juego juego) {
        Button botonFinTurno = new Button();
        botonFinTurno.setText("Finalizar Turno");
        FinalizarTurnoEventHandler finalizarTurnoEventHandler = new FinalizarTurnoEventHandler(juego, vista);
        botonFinTurno.setOnAction(finalizarTurnoEventHandler);
        Button botonObjetivo = new Button();
        botonObjetivo.setText("Ver Objetivo"); //hacer objetivos
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
        ColocarEjercitosEventHandler colocarEjercitosEventHandler = new ColocarEjercitosEventHandler(this);
        botonColocarEjercitos.setOnAction(colocarEjercitosEventHandler);
        VBox contenedor = new VBox( botonCanje, botonColocarEjercitos);
        contenedor.setSpacing(20);
        return contenedor;
    }
    public void mostrarAgregarEjercitos(){
        Label etiqueta = new Label();
        etiqueta.setText("Haga click sobre la ficha del pais en el que desea agregar ejercitos, luego introduzca la cantidad");
        etiqueta.setTextFill(Color.WHITE);
        contenedor.setTop(etiqueta);
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
