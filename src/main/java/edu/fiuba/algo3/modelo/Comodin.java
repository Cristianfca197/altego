package edu.fiuba.algo3.modelo;

public class Comodin implements TipoTarjeta{
    public Comodin(){

    }
    @Override
    public boolean esBarco() {
        return true;
    }
    @Override
    public boolean esCanion() {
        return true;
    }
    @Override
    public boolean esGlobo() {
        return true;
    }

    @Override
    public void agregarseALista(MazoTarjetasPais listaTarjetas) { listaTarjetas.agregarComodin(); }
    @Override
    public boolean esIgual(TipoTarjeta unTipo) {
        return true;
    }
}
