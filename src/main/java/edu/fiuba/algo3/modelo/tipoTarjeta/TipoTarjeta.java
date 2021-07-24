package edu.fiuba.algo3.modelo.tipoTarjeta;

public interface TipoTarjeta {

    boolean esGlobo();
    boolean esCanion();
    boolean esBarco();

    boolean esIgual(TipoTarjeta obtenerTipo);

    String obtenerNombre();
}
