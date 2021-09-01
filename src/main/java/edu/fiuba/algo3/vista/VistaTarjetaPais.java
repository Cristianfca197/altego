package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.CanjeEventHandler;
import edu.fiuba.algo3.controlador.TarjetaElegidaEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class VistaTarjetaPais extends Pane {

    private final Juego juego;
    private final HashMap<String, VistaPais> paises;
    private final boolean esCanje;
    private final ArrayList<String> tarjetasElegidas;
    private final VistaEtapaColocacion vistaColocacion;

    public VistaTarjetaPais(ArrayList<TarjetaPais> tarjetasPais, Juego juego, HashMap<String, VistaPais> paises, boolean esCanje, VistaEtapaColocacion vistaColocacion){
        this.esCanje = esCanje;
        this.juego = juego;
        this.paises = paises;
        this.tarjetasElegidas = new ArrayList<String>();
        this.vistaColocacion = vistaColocacion;

        HBox tarjetas = new HBox();
        tarjetas.setSpacing(10);

        for(TarjetaPais tarjeta: tarjetasPais){
            Label nombreTarjeta = new Label();
            nombreTarjeta.setText(tarjeta.obtenerPais().obtenerNombre());
            nombreTarjeta.setLayoutX(45);
            nombreTarjeta.setLayoutY(150);

            if (tarjeta.obtenerTipo().esCanion() && tarjeta.obtenerTipo().esGlobo()){
                tarjetas.getChildren().add(crearTarjetaComodin(nombreTarjeta));
            }
            else if(tarjeta.obtenerTipo().esCanion()){
                tarjetas.getChildren().add(crearTarjetaCanion(nombreTarjeta));
            }
            else if(tarjeta.obtenerTipo().esGlobo()){
                tarjetas.getChildren().add(crearTarjetaGlobo(nombreTarjeta));
            }
            else{
                tarjetas.getChildren().add(crearTarjetaBarco(nombreTarjeta));
            }
        }

        Button botonCanje = new Button();
        botonCanje.setText("Realizar canje");
        botonCanje.setAlignment(Pos.BOTTOM_CENTER);
        CanjeEventHandler canjeEventHandler = new CanjeEventHandler(juego, tarjetasElegidas, vistaColocacion);
        botonCanje.setOnAction(canjeEventHandler);
        
        this.getChildren().addAll(tarjetas);
        if(esCanje){
            this.getChildren().add(botonCanje);
        }
    }
    
    public Pane crearTarjetaGlobo(Label nombreTarjeta){

        Image tipoTarjeta = new Image("file:" + "multimedia/globo.jpg", 300, 150, true, true);
        ImageView imagenTarjeta = new ImageView(tipoTarjeta);
        Pane pane = new Pane(imagenTarjeta , nombreTarjeta);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        TarjetaElegidaEventHandler tarjetaElegidaEventHandler = new TarjetaElegidaEventHandler(nombreTarjeta.getText(), juego, paises, esCanje, this);
        pane.setOnMouseClicked(tarjetaElegidaEventHandler);
        return pane;
    }
    public Pane crearTarjetaBarco(Label nombreTarjeta){
        Image tipoTarjeta = new Image("file:" + "multimedia/barco.jpg", 300, 150, true, true);
        ImageView imagenTarjeta = new ImageView(tipoTarjeta);
        Pane pane = new Pane(imagenTarjeta , nombreTarjeta);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        TarjetaElegidaEventHandler tarjetaElegidaEventHandler = new TarjetaElegidaEventHandler(nombreTarjeta.getText(), juego, paises, esCanje, this);
        pane.setOnMouseClicked(tarjetaElegidaEventHandler);
        return pane;
    }
    public Pane crearTarjetaComodin(Label nombreTarjeta){
        Image tipoTarjeta = new Image("file:" + "multimedia/comodin.jpg", 300 ,150, true, true);
        ImageView imagenTarjeta = new ImageView(tipoTarjeta);
        Pane pane = new Pane(imagenTarjeta , nombreTarjeta);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        TarjetaElegidaEventHandler tarjetaElegidaEventHandler = new TarjetaElegidaEventHandler(nombreTarjeta.getText(), juego, paises, esCanje, this);
        pane.setOnMouseClicked(tarjetaElegidaEventHandler);
        return pane;
    }
    public Pane crearTarjetaCanion(Label nombreTarjeta){

        Image tipoTarjeta = new Image("file:" + "multimedia/canion.jpg", 300 ,150, true, true);
        ImageView imagenTarjeta = new ImageView(tipoTarjeta);
        Pane pane = new Pane(imagenTarjeta , nombreTarjeta);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        TarjetaElegidaEventHandler tarjetaElegidaEventHandler = new TarjetaElegidaEventHandler(nombreTarjeta.getText(), juego, paises, esCanje, this);
        pane.setOnMouseClicked(tarjetaElegidaEventHandler);
        return pane;
    }

    public void agregarTarjetaElegida(String nombreTarjeta){
        tarjetasElegidas.add(nombreTarjeta);
    }

    public ArrayList<String> obretenerTarjetasElegidas(){
        return tarjetasElegidas;
    }
}
