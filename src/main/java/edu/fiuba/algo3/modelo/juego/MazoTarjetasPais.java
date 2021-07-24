package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.HashMap;

public class MazoTarjetasPais {

    private final HashMap<String, TarjetaPais> tarjetas;

    public MazoTarjetasPais(){
        this.tarjetas = new HashMap<>();
    }
    public void agregarTarjeta(TarjetaPais unaTarjeta){
        this.tarjetas.put(unaTarjeta.obtenerPais().obtenerNombre(), unaTarjeta);
    }

    public ArrayList<TarjetaPais> obtenerTarjetas() {
        return new ArrayList<TarjetaPais>(tarjetas.values());
    }
}
