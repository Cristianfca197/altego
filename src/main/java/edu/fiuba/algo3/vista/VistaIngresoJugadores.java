package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.InicioEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaIngresoJugadores extends VBox {
    private final ArrayList<TextField> nombres;

    public VistaIngresoJugadores(Juego juego, SeleccionarVista seleccionarVista, int cantidadJugadores, ArrayList<String> colores){
        this.nombres = new ArrayList<TextField>();
        for (int i = 0; i < cantidadJugadores; i++){
            VBox jugador = informacionJugador(colores.get(i));
            this.getChildren().add(jugador);
        }
        Button botonEnviar = new Button();
        InicioEventHandler inicioEventHandler = new InicioEventHandler(juego, seleccionarVista, nombres);
        botonEnviar.setOnAction(inicioEventHandler);
        this.getChildren().addAll(botonEnviar);
    }
    public VBox informacionJugador(String color){
        Label colorJugador = new Label("Ingrese nombre jugador " + color);
        TextField datoJugador = new TextField();
        nombres.add(datoJugador);
        VBox jugador = new VBox(colorJugador, datoJugador);
        jugador.setSpacing(30);
        jugador.setAlignment(Pos.CENTER);
        jugador.setPadding(new Insets(25));
        return jugador;
    }
}
