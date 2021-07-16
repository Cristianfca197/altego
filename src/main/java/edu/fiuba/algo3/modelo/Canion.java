package edu.fiuba.algo3.modelo;

public class Canion implements TipoTarjeta {


    public Canion(){
    }

    @Override
    public void agregarseALista(TarjetasPais listaTarjetas) {
        listaTarjetas.agregarCanion();
    }

    public boolean esGlobo(){
        return false;
    }
    public boolean esCanion(){
        return true;
    }
    public boolean esBarco(){
        return false;
    }
    
}
