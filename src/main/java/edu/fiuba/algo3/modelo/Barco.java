package edu.fiuba.algo3.modelo;

public class Barco implements TipoTarjeta {

    public Barco(){
    }

    @Override
    public void agregarseALista(TarjetasPais listaTarjetas) {
        listaTarjetas.agregarBarco();
    }

    public boolean esGlobo(){
        return false;
    }
    public boolean esCanion(){
        return false;
    }
    public boolean esBarco(){
        return true;
    }
    
}