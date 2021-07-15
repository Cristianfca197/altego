package edu.fiuba.algo3.modelo;

public class TarjetaPais {

    private TipoTarjeta tipo;
    private Pais pais;
  
    public TarjetaPais(TipoTarjeta unTipo, String unPais) {
        this.pais = new Pais(unPais);
        this.tipo = unTipo;
    }

    public Pais obtenerPais(){
        return this.pais;
    }



}
