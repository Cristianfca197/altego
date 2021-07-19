package edu.fiuba.algo3.modelo;

import java.util.*;

public class Tablero {

    private final ArrayList<Pais> paises;
    private HashMap<String, Continente> continentes = new HashMap<String, Continente>();

    public Tablero(){
        this.paises = new ArrayList<Pais>();
    }
    
    public boolean existeContinente(String unContinente){
        return this.continentes.containsKey(unContinente);
    }

    public Continente obtenerContinente(String unContinente){
        return this.continentes.get(unContinente);
    }

    public void crearContinente(String unContinente){
        this.continentes.put(unContinente, new Continente(unContinente));
    }
    public void agregarPais(Pais unPais){
        this.paises.add(unPais);
    }
    public int obtenerPaisesJugador(Jugador unJugador){
        int cantidadPaises = 0;
        for (int i = 0; i < paises.size(); i++) {
            if (paises.get(i).obtenerFicha().esIgualA(unJugador.obtenerFicha())){
                cantidadPaises ++;
            }
        }
        return cantidadPaises;
    }
    public ArrayList<Continente> obtenerContinentes(){
        return  new ArrayList<Continente>(this.continentes.values());
    }
    public int fichasContinente(Jugador unJugador){
        int cantidadEjercitos = 0;
        ArrayList<Continente> listaContinentes = this.obtenerContinentes();
        for (int i = 0; i < listaContinentes.size(); i++) {
            cantidadEjercitos = listaContinentes.get(i).jugadorAgregaEjercitos(unJugador);
        }
        return cantidadEjercitos;
    }
}
