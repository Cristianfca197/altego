package edu.fiuba.algo3.modelo.canje;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.exception.ExcepcionCanjeInvalido;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;

public class PrimerCanje implements Canje{

    public PrimerCanje(){ }

    public int realizarCanje(ArrayList<TarjetaPais> tarjetasPais) throws ExcepcionCanjeInvalido{
        if(tarjetasPais.size() != 3){throw new ExcepcionCanjeInvalido("El canje solo se puede realizar con tres tarjetas");}

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
        else { throw new ExcepcionCanjeInvalido("El canje es inválido");}

    }
    public Canje actualizarCanje(){
        return new SegundoCanje();
    }
}
 