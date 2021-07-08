package edu.fiuba.algo3.modelo;

public class Batalla {
    public void combateEntre(Pais atacante, Pais defensor) {
       Pais perdedor = this.evaluarDados(atacante, defensor);
       if(perdedor == defensor){
           defensor.eliminarEjercito();
           atacante.ocuparPais(defensor, atacante.cantidadDeEjercitos()-1);
       }
    }
    public Pais evaluarDados(Pais atacante, Pais defensor){
        if(atacante.dados() > defensor.dados()){ return defensor;}
        return atacante;
    }
}
