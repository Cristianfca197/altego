package edu.fiuba.algo3.modelo;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecturaArchivoTarjetas {

    private HashMap<String, TarjetaPais> tarjetasPais;

    public LecturaArchivoTarjetas(){}
    
    public boolean leerArchivos() {

        this.tarjetasPais = new HashMap<>();

        @SuppressWarnings("unchecked")
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/archivos_paises/Teg - Cartas.json")) {
            
            // Lectura archivo
            Object obj = jsonParser.parse(reader);

            JSONArray listaCartas = (JSONArray) obj;

            //Iteracion por cada carta leida
            listaCartas.forEach(carta -> parseCartaObject((JSONObject) carta));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private void parseCartaObject(JSONObject carta){
        // Obtener carta
        carta.get("");

        // Obtener nombre pais
        String pais = (String) carta.get("Pais");

        // Obtener simbolo
        String simbolo = (String) carta.get("Simbolo");
        
        switch (simbolo){
            case "Globo": 
                this.tarjetasPais.put(pais, new TarjetaPais(new Globo(), pais));
                break;
            case "Barco":
                this.tarjetasPais.put(pais, new TarjetaPais(new Barco(), pais));
                break;
            case "Cañon": 
                this.tarjetasPais.put(pais, new TarjetaPais(new Canion(), pais));
                break;
            default:
                this.tarjetasPais.put(pais, new TarjetaPais(new Comodin(), pais));
        }
    }

    public HashMap<String, TarjetaPais> getTarjetas(){
        return this.tarjetasPais;
    }
}
