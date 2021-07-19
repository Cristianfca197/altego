package edu.fiuba.algo3.modelo;

public class Barco implements TipoTarjeta {

    public Barco(){
    }

    @Override
    public void agregarseALista(MazoTarjetasPais listaTarjetas) {
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

    @Override
    public boolean esIgual(TipoTarjeta unTipo) {
        return unTipo.esBarco();
    }
}