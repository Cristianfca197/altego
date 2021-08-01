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
    public void vaciar(){
        this.tarjetas.clear();
    }
    public TarjetaPais obtenerTarjeta(String nombreTarjeta){
        return tarjetas.get(nombreTarjeta);
    }
    public ArrayList<TarjetaPais> obtenerTarjetas() {
        return new ArrayList<>(tarjetas.values());
    }


}
