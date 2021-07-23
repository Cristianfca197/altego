package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

interface Canje {

     int realizarCanje(ArrayList<TarjetaPais> tarjetasPais) throws ExcepcionCanjeInvalido;
     Canje actualizarCanje();

}
