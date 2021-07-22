package edu.fiuba.algo3.modelo;

public class ExcepcionActivacionTarjetaInvalido extends Exception{
    //agregar runtime Exception en todas las excepciones
    public ExcepcionActivacionTarjetaInvalido(String msg){
        super(msg);
    }
}
