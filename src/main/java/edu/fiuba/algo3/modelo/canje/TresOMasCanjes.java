package edu.fiuba.algo3.modelo.canje;

public class TresOMasCanjes extends Canje{

    private Integer cantidadCanjes;

    public TresOMasCanjes(){
        this.cantidadCanjes = 3;
    }

    public int ejercitosExtra(){
        this.cantidadCanjes += 1;
        return (cantidadCanjes - 2) * 5;
    }
    public Canje actualizarCanje(){
        return this;
    }
}
