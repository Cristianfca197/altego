package edu.fiuba.algo3.modelo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Dictionary;

public class CargarArchivo {
    private Gson gson = new Gson();
    private String pathCartas = "/src/main/archivos_paises/Teg - Cartas.json";
    private String pathFronteras = "/src/main/archivos_paises/Teg - Fronteras.json";

    public Boolean cargarPaises(Dictionary<String, TipoTarjeta> dicc) {
        return (this.cargarSimbolos(dicc) || this.cargarLimitrofes(dicc));
    }

    private Boolean cargarSimbolos(Dictionary<String, TipoTarjeta> dicc) {

        try (Reader reader = new FileReader(pathCartas)) {

            // Convert JSON File to Java Object
            Carta[] listaPaises = gson.fromJson(reader, Carta[].class);

            for (Carta pais : listaPaises) {
                dicc.put(pais.getPais(),toTipoTarjeta(pais.getSimbolo()));
            }
            

        } catch (IOException e) {
            return false;
        }

        return true;
    }

    private Boolean cargarLimitrofes(Dictionary<String, TipoTarjeta> dicc) {
       
        try (Reader reader = new FileReader(pathFronteras)) {

            // Convert JSON File to Java Object
            Frontera[] listaPaises = gson.fromJson(reader, Frontera[].class);
        
            for (Frontera pais : listaPaises) {
                
            }
            

        } catch (IOException e) {
            return false;
        }

        return true;
    }

    private TipoTarjeta toTipoTarjeta(String tipo) {
        if(tipo == "Globo") {
            return new Globo();
        } else if(tipo == "Barco") {
            return new Barco();
        }
        return new Canion();
    }

}
