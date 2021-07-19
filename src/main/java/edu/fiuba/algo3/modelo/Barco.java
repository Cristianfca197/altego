package edu.fiuba.algo3.modelo;

public class Barco implements TipoTarjeta {
    private String nombre;
    public Barco(){
        this.nombre = "Barco";
    }
    public String obtenerNombre(){return nombre;}

    @Override
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