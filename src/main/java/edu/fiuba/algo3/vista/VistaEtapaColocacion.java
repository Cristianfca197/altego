package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.FinalizarTurnoEventHandler;
import edu.fiuba.algo3.controlador.MostrarObjetivosEventHandler;
import edu.fiuba.algo3.controlador.MostrarTarjetasEventHandler;
import edu.fiuba.algo3.controlador.PaisSeleccionadoEventHandler;
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

import java.util.HashMap;

public class VistaEtapaColocacion extends StackPane {
    private final BorderPane contenedor;
    private final SeleccionarVista vista;
    private final Mapa mapa;
    private final Juego juego;
    private Label jugadorActual;
    private Label proximoJugador;
    private Label ejercitos;

    public VistaEtapaColocacion(Mapa mapa, String nombreJugadorActual, String nombreSiguienteJugador, String colorJugActual, Juego juego, SeleccionarVista seleccionarVista, int ejercitosDisponibles){
        this.vista = seleccionarVista;
        this.mapa = mapa;
        this.juego = juego;
        HBox datosTurno = this.datosTurno(nombreJugadorActual, nombreSiguienteJugador, ejercitosDisponibles, colorJugActual);
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


        HashMap<String, VistaPais> paises = mapa.obtenerPaises();
        for(String nombre: paises.keySet()){
            VistaPais pais = paises.get(nombre);
            PaisSeleccionadoEventHandler paisSeleccionadoEventHandler = new PaisSeleccionadoEventHandler(pais, juego, this);
            pais.setOnMouseClicked(paisSeleccionadoEventHandler);
            contenedor.getChildren().add(pais);
        }
        ObservableList lista = this.getChildren();
        lista.addAll(mapa, contenedor);
        this.setStyle("-fx-background-color: #504d4c");
        setMargin(mapa, new Insets(15,50,0,50));
    }

    private HBox botonesTurno(Juego juego) {

        Button botonFinTurno = new Button();
        botonFinTurno.setText("Finalizar Turno");
        FinalizarTurnoEventHandler finalizarTurnoEventHandler = new FinalizarTurnoEventHandler(juego, vista, this);
        botonFinTurno.setOnAction(finalizarTurnoEventHandler);

        Button botonObjetivo = new Button();
        botonObjetivo.setText("Ver Objetivo");
        MostrarObjetivosEventHandler mostrarObjetivosEventHandler = new MostrarObjetivosEventHandler(vista, juego, this);
        botonObjetivo.setOnAction(mostrarObjetivosEventHandler);
        Button botonTarjetaPais = new Button();
        botonTarjetaPais.setText("Activar Tarjeta");
        MostrarTarjetasEventHandler mostrarTarjetasEventHandler = new MostrarTarjetasEventHandler(vista, juego, mapa.obtenerPaises(), this, false);
        botonTarjetaPais.setOnAction(mostrarTarjetasEventHandler);

        HBox contenedor = new HBox(botonFinTurno, botonObjetivo, botonTarjetaPais);
        contenedor.setSpacing(20);
        return contenedor;
    }

    private VBox botonesJugador() {
        Button botonCanje = new Button();
        botonCanje.setText("Realizar Canje");
        MostrarTarjetasEventHandler mostrarTarjetasEventHandler = new MostrarTarjetasEventHandler(vista, juego, mapa.obtenerPaises(),this, true);
        botonCanje.setOnAction(mostrarTarjetasEventHandler);
        VBox contenedor = new VBox( botonCanje);
        contenedor.setSpacing(20);
        return contenedor;
    }
    private HBox datosTurno(String nombreJugadorActual, String nombreSiguienteJugador, int ejercitosDisponibles, String colorJugadorActual) {

        Label fichasDisponibles = new Label();
        fichasDisponibles.setText("Ejercitos restantes:"+ ejercitosDisponibles);
        fichasDisponibles.setTextFill(Color.WHITE);

        Label datoJugador = new Label();
        datoJugador.setText("Jugador:"+ nombreJugadorActual);
        datoJugador.setTextFill(Color.WHITE);

        Label datColor = new Label();
        datColor.setText("Color:"+ colorJugadorActual);
        datColor.setTextFill(Color.WHITE);

        Label proximoJugador = new Label();
        proximoJugador.setText("Siguiente jugador:"+ nombreSiguienteJugador);
        proximoJugador.setTextFill(Color.WHITE);

        this.jugadorActual = datoJugador;
        this.proximoJugador = proximoJugador;
        this.ejercitos = fichasDisponibles;
        HBox datosTurno = new HBox(fichasDisponibles, datoJugador, datColor, proximoJugador);
        datosTurno.setSpacing(20);
        return datosTurno;
    }
    public void actualizarVista(String nombreJugadorActual, String nombreSiguienteJugador, int cantidadEjercitos){
        this.jugadorActual.setText("Jugador:"+ nombreJugadorActual);
        this.proximoJugador.setText("Siguiente jugador:" + nombreSiguienteJugador);
        this.ejercitos.setText("Ejercitos restantes:" + cantidadEjercitos);
    }
}
