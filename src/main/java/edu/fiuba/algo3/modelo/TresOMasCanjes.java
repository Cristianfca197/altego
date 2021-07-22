package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TresOMasCanjes implements Canje{
    private Integer cantidadCanjes;

    public TresOMasCanjes(){
        this.cantidadCanjes = 3;
    }

    public int realizarCanje(ArrayList<TarjetaPais> tarjetasPais) throws ExcepcionCanjeInvalido{
        if(tarjetasPais.size() != 3){throw new ExcepcionCanjeInvalido("El canje solo se puede realizar con tres tarjetas");}
        
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
        else { throw new ExcepcionCanjeInvalido("El canje es inválido");}

    }
    public Canje actualizarCanje(){
        return this;
    }
}
