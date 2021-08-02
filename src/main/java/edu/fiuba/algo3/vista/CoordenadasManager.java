package edu.fiuba.algo3.vista;

import java.util.HashMap;

public class CoordenadasManager {
    private final HashMap<String, Coordenadas> coordenadas;

    public CoordenadasManager(){
        this.coordenadas = new HashMap<String, Coordenadas>();
        coordenadas.put("Argentina", new Coordenadas(345,500));
        coordenadas.put("Brasil", new Coordenadas(415,420));
        coordenadas.put("Chile", new Coordenadas(315,500));
        coordenadas.put("Colombia", new Coordenadas(315,370));
        coordenadas.put("Uruguay", new Coordenadas(395,450));
        coordenadas.put("Peru", new Coordenadas(335,420));

        coordenadas.put("Alaska", new Coordenadas(95,260));
        coordenadas.put("Yukon", new Coordenadas(145,220));
        coordenadas.put("Canada", new Coordenadas(195,190));
        coordenadas.put("Groenlandia", new Coordenadas(365,200));
        coordenadas.put("Oregon", new Coordenadas(145,300));
        coordenadas.put("Nueva York", new Coordenadas(270,270));
        coordenadas.put("Terranova", new Coordenadas(270,240));
        coordenadas.put("Labrador", new Coordenadas(300,210));
        coordenadas.put("California", new Coordenadas(185,330));
        coordenadas.put("Mexico", new Coordenadas(275,350));

        coordenadas.put("Australia", new Coordenadas(895,470));
        coordenadas.put("Sumatra", new Coordenadas(795,430));
        coordenadas.put("Borneo", new Coordenadas(845,380));
        coordenadas.put("Java", new Coordenadas(885,390));

        coordenadas.put("Madagascar", new Coordenadas(735,480));
        coordenadas.put("Egipto", new Coordenadas(665,420));
        coordenadas.put("Etiopia", new Coordenadas(665,460));
        coordenadas.put("Sudafrica", new Coordenadas(665,500));
        coordenadas.put("Zaire", new Coordenadas(635,490));
        coordenadas.put("Sahara", new Coordenadas(595,430));

        coordenadas.put("Islandia", new Coordenadas(440,240));
        coordenadas.put("Gran Bretania", new Coordenadas(535,260));
        coordenadas.put("Suecia", new Coordenadas(585,190));
        coordenadas.put("Rusia", new Coordenadas(635,190));
        coordenadas.put("Polonia", new Coordenadas(655,310));
        coordenadas.put("Alemania", new Coordenadas(595,290));
        coordenadas.put("Italia", new Coordenadas(595,370));
        coordenadas.put("Francia", new Coordenadas(555,310));
        coordenadas.put("Espania", new Coordenadas(480,350));

        coordenadas.put("Turquia", new Coordenadas(715,310));
        coordenadas.put("Israel", new Coordenadas(715,350));
        coordenadas.put("Arabia", new Coordenadas(735,380));
        coordenadas.put("India", new Coordenadas(815,330));
        coordenadas.put("Malasia", new Coordenadas(865,330));
        coordenadas.put("Iran", new Coordenadas(720,250));
        coordenadas.put("China", new Coordenadas(815,280));
        coordenadas.put("Mongolia", new Coordenadas(755,220));
        coordenadas.put("Gobi", new Coordenadas(765,260));
        coordenadas.put("Siberia", new Coordenadas(755,180));
        coordenadas.put("Aral", new Coordenadas(685,170));
        coordenadas.put("Tartaria", new Coordenadas(705,130));
        coordenadas.put("Taymir", new Coordenadas(745,140));
        coordenadas.put("Kamtchatka", new Coordenadas(795,150));
        coordenadas.put("Japon", new Coordenadas(865,180));


    }
    public Coordenadas getCoordenadas(String nombrePais){
        return this.coordenadas.get(nombrePais);
    }
}
