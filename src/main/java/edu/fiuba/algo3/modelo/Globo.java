package edu.fiuba.algo3.modelo;

public class Globo implements TipoTarjeta {
    private String nombre;
    public Globo(){
        this.nombre = "Globo";
    }
    public String obtenerNombre(){return nombre;}

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