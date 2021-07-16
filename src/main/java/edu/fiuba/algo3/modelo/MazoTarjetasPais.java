package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MazoTarjetasPais {

    private final ArrayList<TarjetaPais> tarjetas;
    private int cantidadGlobos;
    private int cantidadBarcos;
    private int cantidadCanion;
    private int cantidadComodines;

    public MazoTarjetasPais(){
        this.tarjetas = new ArrayList<>();
        this.cantidadGlobos = 0;
        this.cantidadCanion = 0;
        this.cantidadComodines = 0;
        this.cantidadBarcos = 0;
    }
    public void agregarTarjeta(TarjetaPais unaTarjeta){
        this.tarjetas.add(unaTarjeta);
        unaTarjeta.obtenerTipo().agregarseALista(this);
    }
    public void agregarGlobo(){this.cantidadGlobos += 1;}
    public void agregarBarco(){this.cantidadBarcos += 1;}
    public void agregarCanion(){this.cantidadCanion +=1;}
    public void agregarComodin(){this.cantidadComodines +=1;}
    public int cantidadGlobos(){
        return this.cantidadGlobos;
    }
    public int cantidadBarcos(){
        return this.cantidadBarcos;
    }
    public int cantidadCaniones(){
        return this.cantidadCanion;
    }
    public int cantidadComodines(){
        return this.cantidadComodines;
    }
}
