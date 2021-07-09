package edu.fiuba.algo3.modelo;

public class Batalla {
    public void combateEntre(Pais atacante, Pais defensor){/*throws ExcepcionAtaqueInvalido {

        if (atacante.obtenerFicha().esIgualA(defensor.obtenerFicha())){
            throw new ExcepcionAtaqueInvalido("Ataque entre paises aliados no es posible");
        }*/
        /*Validaciones de batalla
        1.Pais atacante tenga mas de 1 ejercito
        2.Paises sean limitrofes
        3.No se puede atacar un pais aliado
        * */
       Pais perdedor = this.evaluarDados(atacante, defensor);
       if(perdedor == defensor && defensor.estaVacio()){
           atacante.ocuparPais(defensor, atacante.cantidadDeEjercitos()-1);
       }
    }
    public Pais evaluarDados(Pais atacante, Pais defensor){
        if(atacante.dados() > defensor.dados()){
            defensor.eliminarEjercito();
            return defensor;
        }
        atacante.eliminarEjercito();
        return atacante;
    }
}
