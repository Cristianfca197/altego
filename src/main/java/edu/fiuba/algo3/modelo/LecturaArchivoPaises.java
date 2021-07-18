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

public class LecturaArchivoPaises {

    public void LecturaArchivoPaises(){

    }
    @SuppressWarnings("unchecked")
    public boolean leerArchivo(HashMap<String, TarjetaPais> tarjetasPaises) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/archivos_paises/Teg - Fronteras.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray listaPaises = (JSONArray) obj;

            //Iterate over employee array
            listaPaises.forEach( emp -> parsePaisObject( (JSONObject) emp, tarjetasPaises ) );

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
    private void parsePaisObject(JSONObject pais, HashMap<String, TarjetaPais> tarjetasPaises){
        
        pais.get("");

        // Obtener nombre pais
        String nombrePais = (String) pais.get("Pais");

        // Obtener continente
        String continente = (String) pais.get("Continente");

        // Obtener paises limitrofe
        String limitrofe = (String) pais.get("Limita con");
        String[] paisesLimitrofes = limitrofe.split(",");

        // CREAR PAIS
        Pais unPais = (tarjetasPaises.get(nombrePais)).obtenerPais();
        unPais.perteneceAlContinente(continente);
        for(String i : paisesLimitrofes){unPais.esLimitrofeCon(tarjetasPaises.get(i).obtenerPais());}
    }
}
