package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Batalla {
    public Batalla(){

    }

    public void combateEntre(Pais atacante, Pais defensor)throws ExcepcionAtaqueInvalido{

        if (atacante.obtenerFicha().esIgualA(defensor.obtenerFicha())){
            throw new ExcepcionAtaqueInvalido("Ataque entre paises aliados no es posible");
        }
        if(!(atacante.esLimitrofeCon(defensor))){
            throw new ExcepcionAtaqueInvalido("Ataque entre paises no limitrofes no es posible");
        }
        if(atacante.cantidadDeEjercitos() < 2){
            throw new ExcepcionAtaqueInvalido("Pais atacante con menos de 2 ejercitos no puede atacar");
        }

        this.evaluarDados(atacante, defensor);
        if(defensor.estaVacio()){
            atacante.ocuparPais(defensor, atacante.cantidadDeEjercitos() - 1);
        }
    }
    public void evaluarDados(Pais atacante, Pais defensor){
        Dados dadosAtacante = new Dados(atacante);
        Dados dadosDefensor = new Dados(defensor);

        this.batallasIndividuales(atacante, defensor, dadosAtacante.obtenerDados(), dadosDefensor.obtenerDados());
    }

    public void batallasIndividuales(Pais atacante, Pais defensor, ArrayList<Integer>listaDadosAtacante,  ArrayList<Integer>listaDadosDefensor) {
        int cantDados = Math.min(listaDadosAtacante.size(), listaDadosDefensor.size());

        for(int i = 0; i < cantDados ; i++) {
            if(listaDadosAtacante.get(i) > listaDadosDefensor.get(i)) {
                defensor.eliminarEjercito();
            }else{
                atacante.eliminarEjercito();
            }
        }
    }
}
