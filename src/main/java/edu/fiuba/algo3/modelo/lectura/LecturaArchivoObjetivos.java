package edu.fiuba.algo3.modelo.lectura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.fiuba.algo3.modelo.objetivo.*;

public class LecturaArchivoObjetivos {

    private Integer cantidadComun;

    public LecturaArchivoObjetivos() {

    }

    @SuppressWarnings("unchecked")
    public boolean leerArchivo(ArrayList<Objetivo> objetivos) {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/archivos_paises/Teg - Objetivos.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray listaObjetivos = (JSONArray) obj;

            // Iterar sobre objetivos
            listaObjetivos.forEach( objetivo -> parseObjetivoObject( (JSONObject) objetivo, objetivos) );

            objetivos.forEach( o -> o.establecerObjetivoComun(this.cantidadComun));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }
    private void parseObjetivoObject(JSONObject objetivo, ArrayList<Objetivo> objetivos){
        
        Objetivo obj;

        objetivo.get("");

        // Obtener titulo
        String titulo = (String) objetivo.get("Objetivo");

        // Obtener tipo
        String tipo = (String) objetivo.get("Tipo");

        if (tipo.equals("Ocupar")) {
            // Obtener continente
            String nombresContinentes = (String) objetivo.get("Ocupar Continente");
            String[] continentesAOcuparJson = nombresContinentes.split(",");
            ArrayList<String> continentesAOcupar = new ArrayList<>();
            
            if (!nombresContinentes.equals("")){
                Collections.addAll(continentesAOcupar, continentesAOcuparJson);
            }

            // Obtener Paises
            String cont = (String) objetivo.get("Ocupar Paises");
            String[] continentesCantidadesJson = cont.split(",");

            HashMap<String, Integer> continentesYCantidades = new HashMap<>();

            for (String s : continentesCantidadesJson) {

                String[] valores = s.split("\\s");
                int cantidad = Integer.parseInt(valores[0]);
                continentesYCantidades.put(this.nombreContinente(valores[1]), cantidad);
            }

            obj = new ObjetivoOcupar(titulo, continentesAOcupar, continentesYCantidades);
            
            objetivos.add(obj);

        } else if (tipo.equals("Destruir")){

            // Obtener equipo a destruir
            String equipo = (String) objetivo.get("Destruir Equipo");

            obj = new ObjetivoDestruir(titulo, this.obtenerEquipo(equipo));
            objetivos.add(obj);
        } else {
            // Obtener cantidad paises
            String stringCantidad = (String) objetivo.get("Ocupar Paises");
            this.cantidadComun = Integer.parseInt(stringCantidad);
        }


        

    }

    private String obtenerEquipo(String equipo) {
        switch (equipo){
            case "Am": 
                return "Amarillo";
            case "A":
                return "Azul";
            case "R": 
                return "Rojo";
            case "N":
                return "Negro";
            case "V":
                return "Verde";
            case "M":
                return "Violeta";
            default:
                return "Amarillo"; // y en caso de error
        }
    }

    private String nombreContinente(String string) {
        switch (string){
            case "AN": 
                return "America del Norte";
            case "E":
                return "Europa";
            case "AS": 
                return "America del Sur";
            case "O":
                return "Oceania";
            case "A":
                return "Asia";
            case "AF":
                return "Africa";
            default:
                return "Limitrofes"; // y en caso de error
        }

    }

}
