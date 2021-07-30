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
        /*
        for( String clave: ejercitos.keySet()){
            panePrinciapal.getChildren().add(ejercitos.get(clave));
        }
         */
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
/*
        StackPane ejercito = ejercitos.get("Argentina");
        ejercito.setLayoutX(345);
        ejercito.setLayoutY(500);
        ejercito = ejercitos.get("Brasil");
        ejercito.setLayoutX(415);
        ejercito.setLayoutY(420);
        ejercito = ejercitos.get("Chile");
        ejercito.setLayoutX(315);
        ejercito.setLayoutY(500);
        ejercito = ejercitos.get("Colombia");
        ejercito.setLayoutX(315);
        ejercito.setLayoutY(370);
        ejercito = ejercitos.get("Uruguay");
        ejercito.setLayoutX(395);
        ejercito.setLayoutY(450);
        ejercito = ejercitos.get("Peru");
        ejercito.setLayoutX(335);
        ejercito.setLayoutY(420);

        ejercito = ejercitos.get("Alaska");
        ejercito.setLayoutX(95);
        ejercito.setLayoutY(260);
        ejercito = ejercitos.get("Yukon");
        ejercito.setLayoutX(145);
        ejercito.setLayoutY(220);
        ejercito = ejercitos.get("Canada");
        ejercito.setLayoutX(195);
        ejercito.setLayoutY(190);
        ejercito = ejercitos.get("Groenlandia");
        ejercito.setLayoutX(365);
        ejercito.setLayoutY(200);
        ejercito = ejercitos.get("Oregon");
        ejercito.setLayoutX(145);
        ejercito.setLayoutY(300);
        ejercito = ejercitos.get("Nueva York");
        ejercito.setLayoutX(270);
        ejercito.setLayoutY(270);
        ejercito = ejercitos.get("Terranova");
        ejercito.setLayoutX(270);
        ejercito.setLayoutY(240);
        ejercito = ejercitos.get("Labrador");
        ejercito.setLayoutX(300);
        ejercito.setLayoutY(210);
        ejercito = ejercitos.get("California");
        ejercito.setLayoutX(185);
        ejercito.setLayoutY(330);
        ejercito = ejercitos.get("Mexico");
        ejercito.setLayoutX(275);
        ejercito.setLayoutY(350);

        ejercito = ejercitos.get("Australia");
        ejercito.setLayoutX(895);
        ejercito.setLayoutY(470);
        ejercito = ejercitos.get("Sumatra");
        ejercito.setLayoutX(795);
        ejercito.setLayoutY(430);
        ejercito = ejercitos.get("Borneo");
        ejercito.setLayoutX(845);
        ejercito.setLayoutY(380);
        ejercito = ejercitos.get("Java");
        ejercito.setLayoutX(885);
        ejercito.setLayoutY(390);


        ejercito = ejercitos.get("Madagascar");
        ejercito.setLayoutX(735);
        ejercito.setLayoutY(480);
        ejercito = ejercitos.get("Egipto");
        ejercito.setLayoutX(665);
        ejercito.setLayoutY(420);
        ejercito = ejercitos.get("Etiopia");
        ejercito.setLayoutX(665);
        ejercito.setLayoutY(460);
        ejercito = ejercitos.get("Sudafrica");
        ejercito.setLayoutX(665);
        ejercito.setLayoutY(500);
        ejercito = ejercitos.get("Zaire");
        ejercito.setLayoutX(635);
        ejercito.setLayoutY(490);
        ejercito = ejercitos.get("Sahara");
        ejercito.setLayoutX(595);
        ejercito.setLayoutY(430);

        ejercito = ejercitos.get("Islandia");
        ejercito.setLayoutX(440);
        ejercito.setLayoutY(240);
        ejercito = ejercitos.get("Gran Bretaña");
        ejercito.setLayoutX(535);
        ejercito.setLayoutY(260);
        ejercito = ejercitos.get("Suecia");
        ejercito.setLayoutX(585);
        ejercito.setLayoutY(190);
        ejercito = ejercitos.get("Rusia");
        ejercito.setLayoutX(635);
        ejercito.setLayoutY(190);
        ejercito = ejercitos.get("Polonia");
        ejercito.setLayoutX(655);
        ejercito.setLayoutY(310);
        ejercito = ejercitos.get("Alemania");
        ejercito.setLayoutX(595);
        ejercito.setLayoutY(290);
        ejercito = ejercitos.get("Italia");
        ejercito.setLayoutX(595);
        ejercito.setLayoutY(370);
        ejercito = ejercitos.get("Francia");
        ejercito.setLayoutX(555);
        ejercito.setLayoutY(310);
        ejercito = ejercitos.get("España");
        ejercito.setLayoutX(480);
        ejercito.setLayoutY(350);

        ejercito = ejercitos.get("Turquia");
        ejercito.setLayoutX(715);
        ejercito.setLayoutY(310);
        ejercito = ejercitos.get("Israel");
        ejercito.setLayoutX(715);
        ejercito.setLayoutY(350);
        ejercito = ejercitos.get("Arabia");
        ejercito.setLayoutX(735);
        ejercito.setLayoutY(380);
        ejercito = ejercitos.get("India");
        ejercito.setLayoutX(815);
        ejercito.setLayoutY(330);
        ejercito = ejercitos.get("Malasia");
        ejercito.setLayoutX(865);
        ejercito.setLayoutY(330);
        ejercito = ejercitos.get("Iran");
        ejercito.setLayoutX(720);
        ejercito.setLayoutY(250);
        ejercito = ejercitos.get("China");
        ejercito.setLayoutX(815);
        ejercito.setLayoutY(280);
        ejercito = ejercitos.get("Mongolia");
        ejercito.setLayoutX(755);
        ejercito.setLayoutY(220);
        ejercito = ejercitos.get("Gobi");
        ejercito.setLayoutX(765);
        ejercito.setLayoutY(260);

        ejercito = ejercitos.get("Siberia");
        ejercito.setLayoutX(755);
        ejercito.setLayoutY(180);
        ejercito = ejercitos.get("Aral");
        ejercito.setLayoutX(685);
        ejercito.setLayoutY(170);
        ejercito = ejercitos.get("Tartaria");
        ejercito.setLayoutX(705);
        ejercito.setLayoutY(130);
        ejercito = ejercitos.get("Taymir");
        ejercito.setLayoutX(745);
        ejercito.setLayoutY(140);
        ejercito = ejercitos.get("Kamtchatka");
        ejercito.setLayoutX(795);
        ejercito.setLayoutY(150);
        ejercito = ejercitos.get("Japon");
        ejercito.setLayoutX(865);
        ejercito.setLayoutY(180);
*/
    }


}
