package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashSet;

public class MazoTarjetasPais {

    private final HashSet<TarjetaPais> tarjetas;
    private int cantidadGlobos;
    private int cantidadBarcos;
    private int cantidadCanion;
    private int cantidadComodines;

    public MazoTarjetasPais(){
        this.tarjetas = new HashSet();
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

    public boolean esCanjeValido(){
        if(this.cantidadCanion >= 3 || this.cantidadGlobos >= 3 || this.cantidadBarcos >= 3){
            return true;
        }
        else if((this.cantidadCanion == 2 || this.cantidadGlobos == 2 || this.cantidadBarcos == 2) && this.cantidadComodines >= 1){
            return true;
        }
        else if (this.cantidadBarcos >=1 && this.cantidadGlobos >= 1 && this.cantidadCanion >= 1){
            return true;
        }

        else return false;
    }

    public ArrayList<TarjetaPais> obtenerTarjetas() {
        ArrayList<TarjetaPais> lista= new ArrayList<>();
        for(TarjetaPais i :tarjetas){ lista.add(i); }
        tarjetas.removeAll(lista);
        return lista;//Pendiente que devuelva una lista que pueda hacer una canje
    }
}
