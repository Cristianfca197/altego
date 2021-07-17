package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class CuartoOMasCanjes implements Canje{
    private Integer cantidadCanjes;

    public CuartoOMasCanjes(){
        this.cantidadCanjes = 4;
    }

    public int realizarCanje(ArrayList<TarjetaPais> tarjetasPais) {
        if(tarjetasPais.size() != 3){return 0;}//Cambiar a un execepcion CanjeInvalido
        TarjetaPais primerTarjeta = tarjetasPais.get(0);
        TarjetaPais segundaTarjeta = tarjetasPais.get(1);
        TarjetaPais tercerTarjeta = tarjetasPais.get(2);
        if (primerTarjeta.esDelMismoTipo(segundaTarjeta) && segundaTarjeta.esDelMismoTipo(tercerTarjeta)) {
            this.cantidadCanjes +=1;
            return (cantidadCanjes -2)*5;
        }
        if ((!primerTarjeta.esDelMismoTipo(segundaTarjeta) && !primerTarjeta.esDelMismoTipo(tercerTarjeta))
                && !segundaTarjeta.esDelMismoTipo(tercerTarjeta)) {
            this.cantidadCanjes +=1;
            return (cantidadCanjes -2)*5;
        }
        return 0;

    }
}
