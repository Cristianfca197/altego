package edu.fiuba.algo3.modelo;

public class Canion implements TipoTarjeta {


    public Canion(){
    }

    @Override
    public void agregarseALista(MazoTarjetasPais listaTarjetas) {
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
