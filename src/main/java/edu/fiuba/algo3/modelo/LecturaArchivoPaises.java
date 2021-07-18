package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecturaArchivoPaises {
    private HashMap<String, Pais> paises;

    public void LecturaArchivoPaises(){

    }
    @SuppressWarnings("unchecked")
    public boolean leerArchivo() {
        this.paises = new HashMap<String, Pais>();
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
        Pais unPais = new Pais(nombrePais);
        unPais.perteneceAlContinente(continente);
        unPais.losNombresDeLosPaisesLimitrofesSon(paisesLimitrofes);
        this.paises.put(nombrePais, unPais);
    }

    public HashMap<String, Pais> getPaises() { return this.paises; }
}
