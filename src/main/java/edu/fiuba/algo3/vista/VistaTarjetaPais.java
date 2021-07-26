package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class VistaTarjetaPais extends Pane {

    public VistaTarjetaPais(ArrayList<TarjetaPais> tarjetasPais){
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

        this.getChildren().addAll(tarjetas);
    }
    public Pane crearTarjetaGlobo(Label nombreTarjeta){

        Image tipoTarjeta = new Image("file:" + "multimedia/globo.jpeg", 300 ,150, true, true);
        ImageView imagenTarjeta = new ImageView(tipoTarjeta);
        Pane pane = new Pane(imagenTarjeta , nombreTarjeta);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return pane;
    }
    public Pane crearTarjetaBarco(Label nombreTarjeta){
        Image tipoTarjeta = new Image("file:" + "multimedia/barco.jpeg", 300 ,150, true, true);
        ImageView imagenTarjeta = new ImageView(tipoTarjeta);
        Pane pane = new Pane(imagenTarjeta , nombreTarjeta);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return pane;
    }
    public Pane crearTarjetaComodin(Label nombreTarjeta){
        Image tipoTarjeta = new Image("file:" + "multimedia/comodin.jpg", 300 ,150, true, true);
        ImageView imagenTarjeta = new ImageView(tipoTarjeta);
        Pane pane = new Pane(imagenTarjeta , nombreTarjeta);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return pane;
    }
    public Pane crearTarjetaCanion(Label nombreTarjeta){

        Image tipoTarjeta = new Image("file:" + "multimedia/canion.jpeg", 300 ,150, true, true);
        ImageView imagenTarjeta = new ImageView(tipoTarjeta);
        Pane pane = new Pane(imagenTarjeta , nombreTarjeta);
        pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return pane;
    }
}
