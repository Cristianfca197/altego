package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class SegundoCanje implements Canje{
    public SegundoCanje(){ }

    public int realizarCanje(ArrayList<TarjetaPais> tarjetasPais) throws ExcepcionCanjeInvalido{
        if(tarjetasPais.size() != 3){throw new ExcepcionCanjeInvalido("El canje solo se puede realizar con tres tarjetas");}

        TarjetaPais primerTarjeta = tarjetasPais.get(0);
        TarjetaPais segundaTarjeta = tarjetasPais.get(1);
        TarjetaPais tercerTarjeta = tarjetasPais.get(2);
        if (primerTarjeta.esDelMismoTipo(segundaTarjeta) && segundaTarjeta.esDelMismoTipo(tercerTarjeta)) {
            return 7;
        }
        if ((!primerTarjeta.esDelMismoTipo(segundaTarjeta) && !primerTarjeta.esDelMismoTipo(tercerTarjeta))
                && !segundaTarjeta.esDelMismoTipo(tercerTarjeta)) {
            return 7;
        }
        else { throw new ExcepcionCanjeInvalido("El canje es inválido");}

    }
    public Canje actualizarCanje(){
        return new TercerCanje();
    }
}
