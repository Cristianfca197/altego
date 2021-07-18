package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecturaArchivoPaises {

    @SuppressWarnings("unchecked")
    public void leerArchivo() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/archivos_paises/Teg - Fronteras.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray listaPaises = (JSONArray) obj;

            //Iterate over employee array
            listaPaises.forEach( emp -> parsePaisObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private void parsePaisObject(JSONObject pais){
        
        pais.get("");

        // Obtener nombre pais
        String nombrePais = (String) pais.get("Pais");

        // Obtener continente
        String continente = (String) pais.get("Continente");

        // Obtener paises limitrofe
        String limitrofe = (String) pais.get("Limita con");
        String[] paisesLimitrofes = limitrofe.split(",");

        // CREAR PAIS
    }

}
