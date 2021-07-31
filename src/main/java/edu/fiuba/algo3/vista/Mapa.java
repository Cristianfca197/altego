package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.juego.Pais;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;

public class Mapa extends Pane {

    private final HashMap<String, VistaPais> paises;

    public Mapa(ArrayList<Pais> paises){
        Image mapa = new Image("file:" + "multimedia/tableroTEG.png", 857 ,613, true, true);

        ImageView imagenMapa = new ImageView(mapa);
        HashMap<String,VistaPais> ejercitos = new HashMap<String, VistaPais>();
        for(Pais unPais: paises){
            VistaPais vistaPais = new VistaPais(unPais.cantidadDeEjercitos(), unPais.obtenerFicha().color(), unPais.obtenerNombre());
            ejercitos.put(unPais.obtenerNombre(), vistaPais);

        }
        cargarPosiciones(ejercitos);
        Pane panePrinciapal = new Pane(imagenMapa);
        panePrinciapal.setPadding(new Insets(20));
        this.paises = ejercitos;
        this.getChildren().add(panePrinciapal);
    }
    public HashMap<String, VistaPais> obtenerPaises(){return this.paises;}

    public void cargarPosiciones(HashMap<String, VistaPais> ejercitos){
        CoordenadasManager manager = new CoordenadasManager();
        ejercitos.forEach((nombrePais, ejercito) ->{
            Coordenadas coordenadas = manager.getCoordenadas(nombrePais);
            ejercito.setLayoutX(coordenadas.getX());
            ejercito.setLayoutY(coordenadas.getY());
        });

    }


}
