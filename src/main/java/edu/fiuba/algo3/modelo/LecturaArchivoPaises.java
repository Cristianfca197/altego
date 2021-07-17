package edu.fiuba.algo3.modelo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
            System.out.println(listaPaises);

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
    private static void parsePaisObject(JSONObject pais)
    {
        //Get employee object within list
        JSONObject PaisObject = (JSONObject) pais.get("");

        //Get employee first name
        String firstName = (String) pais.get("Pais");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) pais.get("Continente");
        System.out.println(lastName);


        //Get employee last name
        String limitrofe = (String) pais.get("Limita con");
        System.out.println(limitrofe);

    }
}
