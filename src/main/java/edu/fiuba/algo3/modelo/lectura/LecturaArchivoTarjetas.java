package edu.fiuba.algo3.modelo.lectura;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.tipoTarjeta.Barco;
import edu.fiuba.algo3.modelo.tipoTarjeta.Canion;
import edu.fiuba.algo3.modelo.tipoTarjeta.Comodin;
import edu.fiuba.algo3.modelo.tipoTarjeta.Globo;

public class LecturaArchivoTarjetas {

    private final Globo globo;
    private final Comodin comodin;
    private final Canion canion;
    private final Barco barco;

    private HashMap<String, TarjetaPais> tarjetasPais;

    public LecturaArchivoTarjetas(){
        this.globo = new Globo();
        this.comodin = new Comodin();
        this.canion = new Canion();
        this.barco = new Barco();
    }
    
    public boolean leerArchivos() {

        this.tarjetasPais = new HashMap<>();

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
                this.tarjetasPais.put(pais, new TarjetaPais(this.globo, pais));
                break;
            case "Barco":
                this.tarjetasPais.put(pais, new TarjetaPais(this.barco, pais));
                break;
            case "Cañon": 
                this.tarjetasPais.put(pais, new TarjetaPais(this.canion, pais));
                break;
            default:
                this.tarjetasPais.put(pais, new TarjetaPais(this.comodin, pais));
        }
    }

    public HashMap<String, TarjetaPais> getTarjetas(){
        return this.tarjetasPais;
    }
}
