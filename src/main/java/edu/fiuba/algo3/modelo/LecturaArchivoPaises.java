package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecturaArchivoPaises {

    private Tablero tablero;

    public LecturaArchivoPaises(){

    }
    @SuppressWarnings("unchecked")
    public boolean leerArchivo(HashMap<String, TarjetaPais> tarjetasPaises, Tablero unTablero) {
        this.tablero = unTablero;

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/archivos_paises/Teg - Fronteras.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray listaPaises = (JSONArray) obj;

            // Iterar sobre paises
            listaPaises.forEach( pais -> parsePaisObject( (JSONObject) pais, tarjetasPaises) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
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
        
        if (!this.tablero.existeContinente(continente))
            this.tablero.crearContinente(continente);

        unPais.perteneceAlContinente(this.tablero.obtenerContinente(continente));
        tablero.agregarPais(unPais);
        
        for(String i : paisesLimitrofes){
            unPais.sonLimitrofesEntre(tarjetasPaises.get(i).obtenerPais());
        }
    }
}
