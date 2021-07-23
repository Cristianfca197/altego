package edu.fiuba.algo3.modelo.exception;

public class ExcepcionActivacionTarjetaInvalido extends RuntimeException{
    //agregar runtime Exception en todas las excepciones
    public ExcepcionActivacionTarjetaInvalido(String msg){
        super(msg);
    }
}
