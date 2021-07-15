package edu.fiuba.algo3.modelo;

public class Barco implements TipoTarjeta {

    public Barco(){
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