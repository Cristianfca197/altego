package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.FInTurnoEventHandler;
import edu.fiuba.algo3.controlador.MostrarObjetivosEventHandler;
import edu.fiuba.algo3.controlador.PaisReagruparEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class VistaEtapaReagrupar extends StackPane {

    private final SeleccionarVista vista;
    private Label jugadorActual;
    private Label proximoJugador;
    private Label informacion;
    private VistaPais paisOrigen = null;

    public VistaEtapaReagrupar(Mapa mapa, String nombreJugadorActual, String nombreSiguienteJugador, String colorJugadorActual, Juego juego, SeleccionarVista seleccionarVista){
        this.vista = seleccionarVista;
        HBox datosTurno = this.datosTurno(nombreJugadorActual, nombreSiguienteJugador, colorJugadorActual);
        HBox contenedorBotones2 = this.botonesTurno(juego);
        BorderPane contenedor = new BorderPane();
        contenedor.setTop(datosTurno);
        contenedor.setBottom(contenedorBotones2);
        contenedor.setLayoutY(10);
        BorderPane.setMargin(datosTurno, new Insets(0, 0, 0, 200));
        BorderPane.setMargin(contenedorBotones2, new Insets(0, 0, 0, 340));

        HashMap<String, VistaPais> paises = mapa.obtenerPaises();
        for(String nombre: paises.keySet()){
            VistaPais pais = paises.get(nombre);
            PaisReagruparEventHandler paisReagruparEventHandler = new PaisReagruparEventHandler(pais, this, juego);
            pais.setOnMouseClicked(paisReagruparEventHandler);
            contenedor.getChildren().add(pais);
        }

        ObservableList lista = this.getChildren();
        lista.addAll(mapa, contenedor);
        this.setStyle("-fx-background-color: #504d4c");
        setMargin(mapa, new Insets(15,0,0,55));
    }

    private HBox botonesTurno(Juego juego) {
        Button finDeTurno = new Button();
        finDeTurno.setText("Finalizar Turno");
        finDeTurno.setStyle(new CargarEstiloBotones("#FFC300").ObtenerEstilo());
        FInTurnoEventHandler fInTurnoEventHandler = new FInTurnoEventHandler(juego, vista);
        finDeTurno.setOnAction(fInTurnoEventHandler);
        Button botonObjetivo = new Button();
        botonObjetivo.setText("Ver Objetivo");
        botonObjetivo.setStyle(new CargarEstiloBotones("#229954").ObtenerEstilo());
        MostrarObjetivosEventHandler mostrarObjetivosEventHandler = new MostrarObjetivosEventHandler(vista, juego);
        botonObjetivo.setOnAction(mostrarObjetivosEventHandler);
        HBox contenedor = new HBox(finDeTurno, botonObjetivo);
        contenedor.setSpacing(20);
        setMargin(contenedor, new Insets(0,0,0,450));
        return contenedor;
    }


    private HBox datosTurno(String nombreJugadorActual, String nombreSiguienteJugador, String colorJugadorActual) {

        Label informacion = new Label();
        informacion.setText("Seleccione el pais del que va a mover ejercitos");
        informacion.setTextFill(Color.WHITE);

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
        this.informacion = informacion;
        HBox datosTurno = new HBox(informacion, datoJugador, datColor, proximoJugador);
        datosTurno.setSpacing(20);
        return datosTurno;
    }

    public void paisOrigenElegido(VistaPais pais){
        this.informacion.setText("Pais de origen elegido, eliga el destino");
        this.paisOrigen = pais;
    }
    public VistaPais obtenerPaisOrigen(){
        return this.paisOrigen;
    }

    public void fichasMovidas(){
        informacion.setText("Seleccione el pais de origen");
        paisOrigen = null;
    }
}
