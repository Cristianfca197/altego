package edu.fiuba.algo3.modelo.lectura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.fiuba.algo3.modelo.continente.*;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.objetivo.*;

public class LecturaArchivoObjetivos {

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
        System.out.println(tipo);
        if (tipo.equals("Ocupar")){
            // Obtener continente
            String nombresContinentes = (String) objetivo.get("Ocupar Continente");
            String[] nombreContinente = nombresContinentes.split(","); 

            // Obtener Paises
            String cont = (String) objetivo.get("Ocupar Paises");
            String[] continentesCantidadesJson = cont.split(",");

            HashMap<String, Integer> continentesCantidades = new HashMap<String, Integer>();
            
            for (int i = 0; i < continentesCantidadesJson.length; i++) {
                
                String[] valores = continentesCantidadesJson[i].split("\\s");
                int cantidad = Integer.parseInt(valores[0]);
                continentesCantidades.put(this.nombreContinente(valores[1]), cantidad);
            }
            for (int i = 0; i < nombreContinente.length; i++) {
                continentesCantidades.put(nombreContinente[i], this.cantidadPaises(nombreContinente[i]));
            }
            obj = new ObjetivoOcupar(titulo, continentesCantidades);

        } else if (tipo.equals("Destruir")){

            // Obtener equipo a destruir
            String equipo = (String) objetivo.get("Destruir Equipo");

            obj = new ObjetivoDestruir(titulo, equipo);
        } else {
            // Obtener cantidad paises
            String stringCantidad = (String) objetivo.get("Ocupar Paises");
            Integer cantidad = Integer.parseInt(stringCantidad);
            obj = new ObjetivoComun(titulo, cantidad);
        }


        objetivos.add(obj);

    }

    private int cantidadPaises(String string) {

        switch (string) {
            case "America del Sur":
                return (new AmericaDelSur(string)).obtenerCantidadPaises();
            case "America del Norte":
                return (new AmericaDelNorte(string)).obtenerCantidadPaises();
            case "Europa":
                return (new Europa(string)).obtenerCantidadPaises();
            case "Africa":
                return (new Africa(string)).obtenerCantidadPaises();
            case "Asia":
                return (new Asia(string)).obtenerCantidadPaises();
            default:
                return (new Oceania(string)).obtenerCantidadPaises();
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
                return "Limitrofes"; // en caso de error
        }

    }

}
