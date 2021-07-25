package edu.fiuba.algo3.modelo.tipoTarjeta;

public class Canion implements TipoTarjeta {
    private String nombre;

    @Override
    public String obtenerNombre(){return nombre;}

    public Canion(){
        this.nombre = "Canion";
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

    @Override
    public boolean esIgual(TipoTarjeta unTipo) {
        return unTipo.esCanion();
    }
    
}
