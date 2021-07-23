package edu.fiuba.algo3.modelo;

interface TipoTarjeta {

    public boolean esGlobo();
    public boolean esCanion();
    public boolean esBarco();

    boolean esIgual(TipoTarjeta obtenerTipo);

    String obtenerNombre();
}
