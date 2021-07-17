package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PrimerCanje implements Canje{

    public PrimerCanje(){ }

    public int realizarCanje(ArrayList<TarjetaPais> tarjetasPais) {
        if(tarjetasPais.size() != 3){return 0;}//Cambiar a un execepcion CanjeInvalido
        TarjetaPais primerTarjeta = tarjetasPais.get(0);
        TarjetaPais segundaTarjeta = tarjetasPais.get(1);
        TarjetaPais tercerTarjeta = tarjetasPais.get(2);
        if (primerTarjeta.esDelMismoTipo(segundaTarjeta) && segundaTarjeta.esDelMismoTipo(tercerTarjeta)) {
            return 4;
        }
        if ((!primerTarjeta.esDelMismoTipo(segundaTarjeta) && !primerTarjeta.esDelMismoTipo(tercerTarjeta))
            && !segundaTarjeta.esDelMismoTipo(tercerTarjeta)) {
            return 4;
        }
        return 0;

    }
}
 