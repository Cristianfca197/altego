package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Pais {
    private final String nombre;
    private Integer ejercitos;
    private Ficha ficha;
    private final ArrayList<Pais> paisesLimitrofes;

    //pais inicializa sin ejercitos al recibir la tarjeta un jugador le agrega uno marcandolo como suyo
    public Pais(String nombre, Jugador unJugador){
        this.nombre = nombre;
        this.ejercitos = 1;
        this.ficha = unJugador.obtenerFicha();
        this.paisesLimitrofes = new ArrayList<>();
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
        this.ejercitos = this.ejercitos -1 ;
    }

    public void cambiarFicha(Ficha nuevaFicha) {this.ficha = nuevaFicha;}

    public void ocuparPais(Pais paisNuevo, int cantidadEjercito) {
        paisNuevo.cambiarFicha(this.obtenerFicha());
        paisNuevo.colocarEjercitos(cantidadEjercito, this.obtenerFicha());
    }

    public List<Integer> dados() {
        Integer cantDados = this.ejercitos;
        if(cantDados > 3) {
            cantDados = 3;
        }

        List<Integer> dados = new ArrayList<>();
        
        for(int i = 0; i < cantDados; i++) {
            Integer num = (int)Math.floor(Math.random()*(6)+1);
            dados.add(num);
        }

        Collections.sort(dados,Collections.reverseOrder());

        return dados;
    }

    public boolean estaVacio() { return cantidadDeEjercitos() == 0;}

    public void sonLimitrofesEntre(Pais otroPais) {
        this.paisesLimitrofes.add(otroPais);
        otroPais.paisesLimitrofes.add(this);
    }

    public boolean esLimitrofeCon(Pais otroPais) { return otroPais.paisesLimitrofes.contains(this);}
}
