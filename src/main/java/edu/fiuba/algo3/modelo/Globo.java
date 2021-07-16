package edu.fiuba.algo3.modelo;

public class Globo implements TipoTarjeta {

    public Globo(){
    }

    @Override
    public void agregarseALista(TarjetasPais listaTarjetas) {
        listaTarjetas.agregarGlobo();
    }

    public boolean esGlobo(){
        return true;
    }
    public boolean esCanion(){
        return false;
    }
    public boolean esBarco(){
        return false;
    }
    
}