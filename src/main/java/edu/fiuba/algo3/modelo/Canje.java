package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Canje {

    public int realizarCanje(ArrayList<TarjetaPais> tarjetasPais) throws ExcepcionCanjeInvalido;
    public Canje actualizarCanje();

}
