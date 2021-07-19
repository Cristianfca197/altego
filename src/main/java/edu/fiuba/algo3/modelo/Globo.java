package edu.fiuba.algo3.modelo;

public class Globo implements TipoTarjeta {

    public Globo(){
    }

    @Override
    public void agregarseALista(MazoTarjetasPais listaTarjetas) {
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

    @Override
    public boolean esIgual(TipoTarjeta unTipo) {
        return unTipo.esGlobo();
    }
    
}