package edu.fiuba.algo3.modelo;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecturaArchivoTarjetas {
    public LecturaArchivoTarjetas(){}
    public HashSet<TarjetaPais> leerArchivos() {
        HashSet<TarjetaPais> tarjetasPais = new HashSet<>();
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/archivos_paises/Teg - Cartas.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray listaCartas = (JSONArray) obj;
            //System.out.println(listaCartas);

            //Iterate over employee array
            listaCartas.forEach(emp -> tarjetasPais.add(parseCartaObject((JSONObject) emp)));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tarjetasPais;
    }
    private static TarjetaPais parseCartaObject(JSONObject carta)
    {
        //Get employee object within list
        JSONObject cartaObject = (JSONObject) carta.get("");

        //Get employee first name
        String firstName = (String) carta.get("Pais");
        //System.out.println(firstName);

        //Get employee last name
        String lastName = (String) carta.get("Simbolo");
        //System.out.println(lastName);
        switch (lastName){
            case "Globo": return new TarjetaPais(new Globo(), firstName);
            case "Barco": return new TarjetaPais(new Barco(), firstName);
            case "Cañon": return new TarjetaPais(new Canion(), firstName);
            case "Comodin": return new TarjetaPais(new Comodin(), firstName);
        }
        return new TarjetaPais(new Comodin(), "Error");
    }
}
