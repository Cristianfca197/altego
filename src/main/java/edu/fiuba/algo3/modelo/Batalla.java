package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Batalla {
    public Batalla(){

    }

    public void combateEntre(Pais atacante, Pais defensor){
        Dados dadosAtacante = new Dados(atacante.cantidadDeEjercitos() - 1);
        Dados dadosDefensor = new Dados(defensor.cantidadDeEjercitos());
        this.batallasIndividuales(atacante, defensor, dadosAtacante.obtenerDados(), dadosDefensor.obtenerDados());

    }

    public void batallasIndividuales(Pais atacante, Pais defensor, ArrayList<Integer> dadosAtacante, ArrayList<Integer> dadosDefensor) {
        int cantDados = Math.min(dadosAtacante.size(), dadosDefensor.size());

        for(int i = 0; i < cantDados && i < atacante.cantidadDeEjercitos() ; i++) {
            if(dadosAtacante.get(i) > dadosDefensor.get(i)) {
                defensor.eliminarEjercito();
            }else{
                atacante.eliminarEjercito();
            }
        }
        atacante.ocuparPais(defensor, atacante.cantidadDeEjercitos() - 1);
    }
}
