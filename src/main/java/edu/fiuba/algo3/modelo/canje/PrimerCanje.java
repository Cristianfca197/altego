package edu.fiuba.algo3.modelo.canje;

public class PrimerCanje extends Canje{

    public PrimerCanje(){ }

    public int ejercitosExtra(){return 4;}

    public Canje actualizarCanje(){
        return new SegundoCanje();
    }
}
 