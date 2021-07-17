package edu.fiuba.algo3.modelo;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecturaArchivoTarjetas {
    public LecturaArchivoTarjetas(){}
    public void leerArchivos() {
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/archivos_paises/Teg - Cartas.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray listaCartas = (JSONArray) obj;
            System.out.println(listaCartas);

            //Iterate over employee array
            listaCartas.forEach(emp -> parseCartaObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static void parseCartaObject(JSONObject carta)
    {
        //Get employee object within list
        JSONObject cartaObject = (JSONObject) carta.get("");

        //Get employee first name
        String firstName = (String) carta.get("Pais");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) carta.get("Simbolo");
        System.out.println(lastName);

    }
}
