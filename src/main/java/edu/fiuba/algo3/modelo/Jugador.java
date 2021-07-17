package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final Ficha ficha;
    private final MazoTarjetasPais listaTarjetas;
    private final CuartoOMasCanjes canjes;

    public Jugador(){
        this.ficha = new Ficha();
        this.listaTarjetas = new MazoTarjetasPais();
        this.canjes =  new CuartoOMasCanjes();
    }

    public void obtenerTarjeta(TarjetaPais unaTarjeta){
        listaTarjetas.agregarTarjeta(unaTarjeta);
    }

    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais){
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
    }
    public Ficha obtenerFicha(){
        return this.ficha;
    }

    public void colocarEjercitosCanje(Integer cantidadDeEjercitos, Pais pais){
        pais.colocarEjercitos(cantidadDeEjercitos, this.obtenerFicha());

    }
    public int realizarPrimerCanje(){
        if(listaTarjetas.esCanjeValido()){
            PrimerCanje canje = new PrimerCanje();
            return canje.realizarCanje(listaTarjetas.obtenerTarjetas());
        }
        return 0;
    }
    public int realizarSegundoCanje(){
        if(listaTarjetas.esCanjeValido()){
            SegundoCanje canje = new SegundoCanje();
            return canje.realizarCanje(listaTarjetas.obtenerTarjetas());
        }
        return 0;
    }
    public int realizarTercerCanje(){
        if(listaTarjetas.esCanjeValido()){
            TercerCanje canje = new TercerCanje();
            return canje.realizarCanje(listaTarjetas.obtenerTarjetas());
        }
        return 0;
    }
    public int realizarCuartoOMasCanje(){
        if(listaTarjetas.esCanjeValido()){
            return this.canjes.realizarCanje(listaTarjetas.obtenerTarjetas());
        }
        return 0;
    }
}
