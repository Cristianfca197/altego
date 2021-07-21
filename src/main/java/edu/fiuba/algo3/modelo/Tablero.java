package edu.fiuba.algo3.modelo;

import java.util.*;

public class Tablero {

    private final ArrayList<Pais> paises;
    private HashMap<String, Continente> continentes = new HashMap<String, Continente>();

    public Tablero(){
        this.paises = new ArrayList<>();
    }
    
    public boolean existeContinente(String unContinente){
        return this.continentes.containsKey(unContinente);
    }

    public Continente obtenerContinente(String unContinente){
        return this.continentes.get(unContinente);
    }

    public void crearContinente(String unContinente){
        if(unContinente.equals("America del Norte")) {
            this.continentes.put(unContinente, new AmericaDelNorte(unContinente));
        }
        if(unContinente.equals("Africa")) {
            this.continentes.put(unContinente, new Africa(unContinente));
        }
        if(unContinente.equals("America del Sur")) {
            this.continentes.put(unContinente, new AmericaDelSur(unContinente));
        }
        if(unContinente.equals("Asia")) {
            this.continentes.put(unContinente, new Asia(unContinente));
        }
        if(unContinente.equals("Oceania")) {
            this.continentes.put(unContinente, new Oceania(unContinente));
        }
        if(unContinente.equals("Europa")) {
            this.continentes.put(unContinente, new Europa(unContinente));
        }
    }
    public void agregarPais(Pais unPais){
        this.paises.add(unPais);
    }

    public int obtenerCantidadPaisesJugador(Jugador unJugador){
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

    public Pais obtenerPais(String nombrePais){
        for (Pais pais: this.paises) {
            if (pais.obtenerNombre().equals(nombrePais)){
                return pais;
            }
        }
        /// sino excepcion esto es para q deje compilar x ahora
        return paises.get(0);
    }
}
