package edu.fiuba.algo3.modelo;

public class Pais {
    private final String nombre;
    private Integer ejercitos;
    private Ficha ficha;

    //pais inicializa sin ejercitos al recibir la tarjeta un jugador le agrega uno marcandolo como suyo
    public Pais(String nombre, Jugador unJugador){
        this.nombre = nombre;
        this.ejercitos = 1;
        this.ficha = unJugador.obtenerFicha();
    }
    public void colocarEjercitos(Integer unaCantidadDeEjercitos, Ficha unaFicha){
        if(this.ficha.esIgualA(unaFicha)) {
            this.ejercitos += unaCantidadDeEjercitos;
            this.ficha = unaFicha;
        }
    }
    public int cantidadDeEjercitos(){
        return ejercitos;
    }

    public Ficha obtenerFicha(){
        return this.ficha;
    }

    public void eliminarEjercito() {
        this.ejercitos = 0;
    }

    public void cambiarFicha(Ficha nuevaFicha) {this.ficha = nuevaFicha;}

    public void ocuparPais(Pais paisNuevo, int cantidadEjercito) {
        paisNuevo.cambiarFicha(this.obtenerFicha());
        paisNuevo.colocarEjercitos(cantidadEjercito, this.obtenerFicha());
    }

    public int dados() { return ejercitos;}
}
