package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.juego.Pais;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.HashMap;

public class Mapa extends Pane {

    public Mapa(ArrayList<Pais> paises){
        Image mapa = new Image("file:" + "multimedia/tableroTEG.png", 857 ,613, true, true);

        ImageView imagenMapa = new ImageView(mapa);
        HashMap<String,StackPane> ejercitos = new HashMap<String, StackPane>();
        for(Pais unPais: paises){
            VistaPais vistaPais = new VistaPais(unPais.cantidadDeEjercitos(), unPais.obtenerFicha().color(), unPais.obtenerNombre());
            vistaPais.setOnMouseClicked(event ->  {
                System.out.println("asfgrhehga");
            });
            ejercitos.put(unPais.obtenerNombre(), vistaPais);

        }
        cargarPosiciones(ejercitos);

        Pane panePrinciapal = new Pane(imagenMapa);
        panePrinciapal.setPadding(new Insets(20));

        for( String clave: ejercitos.keySet()){
            panePrinciapal.getChildren().add(ejercitos.get(clave));
        }

        this.getChildren().add(panePrinciapal);
    }

    public void cargarPosiciones(HashMap<String, StackPane> ejercitos){
        StackPane ejercito = ejercitos.get("Argentina");
        ejercito.setLayoutX(280);
        ejercito.setLayoutY(480);
        ejercito = ejercitos.get("Brasil");
        ejercito.setLayoutX(350);
        ejercito.setLayoutY(400);
        ejercito = ejercitos.get("Chile");
        ejercito.setLayoutX(250);
        ejercito.setLayoutY(480);
        ejercito = ejercitos.get("Colombia");
        ejercito.setLayoutX(250);
        ejercito.setLayoutY(350);
        ejercito = ejercitos.get("Uruguay");
        ejercito.setLayoutX(330);
        ejercito.setLayoutY(430);
        ejercito = ejercitos.get("Peru");
        ejercito.setLayoutX(270);
        ejercito.setLayoutY(400);

        ejercito = ejercitos.get("Alaska");
        ejercito.setLayoutX(30);
        ejercito.setLayoutY(240);
        ejercito = ejercitos.get("Yukon");
        ejercito.setLayoutX(80);
        ejercito.setLayoutY(200);
        ejercito = ejercitos.get("Canada");
        ejercito.setLayoutX(130);
        ejercito.setLayoutY(170);
        ejercito = ejercitos.get("Groenlandia");
        ejercito.setLayoutX(300);
        ejercito.setLayoutY(180);
        ejercito = ejercitos.get("Oregon");
        ejercito.setLayoutX(80);
        ejercito.setLayoutY(290);
        ejercito = ejercitos.get("Nueva York");
        ejercito.setLayoutX(230);
        ejercito.setLayoutY(260);
        ejercito = ejercitos.get("Terranova");
        ejercito.setLayoutX(230);
        ejercito.setLayoutY(220);
        ejercito = ejercitos.get("Labrador");
        ejercito.setLayoutX(250);
        ejercito.setLayoutY(190);
        ejercito = ejercitos.get("California");
        ejercito.setLayoutX(120);
        ejercito.setLayoutY(320);
        ejercito = ejercitos.get("Mexico");
        ejercito.setLayoutX(210);
        ejercito.setLayoutY(330);

        ejercito = ejercitos.get("Australia");
        ejercito.setLayoutX(830);
        ejercito.setLayoutY(450);
        ejercito = ejercitos.get("Sumatra");
        ejercito.setLayoutX(730);
        ejercito.setLayoutY(410);
        ejercito = ejercitos.get("Borneo");
        ejercito.setLayoutX(780);
        ejercito.setLayoutY(360);
        ejercito = ejercitos.get("Java");
        ejercito.setLayoutX(820);
        ejercito.setLayoutY(370);


        ejercito = ejercitos.get("Madagascar");
        ejercito.setLayoutX(670);
        ejercito.setLayoutY(460);
        ejercito = ejercitos.get("Egipto");
        ejercito.setLayoutX(600);
        ejercito.setLayoutY(400);
        ejercito = ejercitos.get("Etiopia");
        ejercito.setLayoutX(600);
        ejercito.setLayoutY(440);
        ejercito = ejercitos.get("Sudafrica");
        ejercito.setLayoutX(600);
        ejercito.setLayoutY(480);
        ejercito = ejercitos.get("Zaire");
        ejercito.setLayoutX(570);
        ejercito.setLayoutY(460);
        ejercito = ejercitos.get("Sahara");
        ejercito.setLayoutX(530);
        ejercito.setLayoutY(400);

        ejercito = ejercitos.get("Islandia");
        ejercito.setLayoutX(370);
        ejercito.setLayoutY(220);
        ejercito = ejercitos.get("Gran Bretaña");
        ejercito.setLayoutX(470);
        ejercito.setLayoutY(230);
        ejercito = ejercitos.get("Suecia");
        ejercito.setLayoutX(520);
        ejercito.setLayoutY(170);
        ejercito = ejercitos.get("Rusia");
        ejercito.setLayoutX(570);
        ejercito.setLayoutY(170);
        ejercito = ejercitos.get("Polonia");
        ejercito.setLayoutX(590);
        ejercito.setLayoutY(290);
        ejercito = ejercitos.get("Alemania");
        ejercito.setLayoutX(530);
        ejercito.setLayoutY(270);
        ejercito = ejercitos.get("Italia");
        ejercito.setLayoutX(530);
        ejercito.setLayoutY(350);
        ejercito = ejercitos.get("Francia");
        ejercito.setLayoutX(490);
        ejercito.setLayoutY(290);
        ejercito = ejercitos.get("España");
        ejercito.setLayoutX(430);
        ejercito.setLayoutY(330);

        ejercito = ejercitos.get("Turquia");
        ejercito.setLayoutX(650);
        ejercito.setLayoutY(290);
        ejercito = ejercitos.get("Israel");
        ejercito.setLayoutX(650);
        ejercito.setLayoutY(320);
        ejercito = ejercitos.get("Arabia");
        ejercito.setLayoutX(670);
        ejercito.setLayoutY(360);
        ejercito = ejercitos.get("India");
        ejercito.setLayoutX(750);
        ejercito.setLayoutY(310);
        ejercito = ejercitos.get("Malasia");
        ejercito.setLayoutX(800);
        ejercito.setLayoutY(310);
        ejercito = ejercitos.get("Iran");
        ejercito.setLayoutX(660);
        ejercito.setLayoutY(230);
        ejercito = ejercitos.get("China");
        ejercito.setLayoutX(750);
        ejercito.setLayoutY(260);
        ejercito = ejercitos.get("Mongolia");
        ejercito.setLayoutX(690);
        ejercito.setLayoutY(200);
        ejercito = ejercitos.get("Gobi");
        ejercito.setLayoutX(700);
        ejercito.setLayoutY(240);

        ejercito = ejercitos.get("Siberia");
        ejercito.setLayoutX(690);
        ejercito.setLayoutY(160);
        ejercito = ejercitos.get("Aral");
        ejercito.setLayoutX(620);
        ejercito.setLayoutY(150);
        ejercito = ejercitos.get("Tartaria");
        ejercito.setLayoutX(650);
        ejercito.setLayoutY(110);
        ejercito = ejercitos.get("Taymir");
        ejercito.setLayoutX(680);
        ejercito.setLayoutY(120);
        ejercito = ejercitos.get("Kamtchatka");
        ejercito.setLayoutX(730);
        ejercito.setLayoutY(130);
        ejercito = ejercitos.get("Japon");
        ejercito.setLayoutX(800);
        ejercito.setLayoutY(160);

    }


}
