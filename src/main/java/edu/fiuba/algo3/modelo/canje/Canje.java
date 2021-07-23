package edu.fiuba.algo3.modelo.canje;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.exception.ExcepcionCanjeInvalido;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;

public interface Canje {

     int realizarCanje(ArrayList<TarjetaPais> tarjetasPais) throws ExcepcionCanjeInvalido;
     Canje actualizarCanje();

}
