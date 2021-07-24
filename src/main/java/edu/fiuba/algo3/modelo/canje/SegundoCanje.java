package edu.fiuba.algo3.modelo.canje;

public class SegundoCanje extends Canje{

    public SegundoCanje(){ }

    public int ejercitosExtra(){ return 7; }

    public Canje actualizarCanje(){
        return new TresOMasCanjes();
    }
}
