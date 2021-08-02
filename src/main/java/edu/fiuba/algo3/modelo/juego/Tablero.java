package edu.fiuba.algo3.modelo.juego;

import java.util.*;

import edu.fiuba.algo3.modelo.continente.Africa;
import edu.fiuba.algo3.modelo.continente.AmericaDelNorte;
import edu.fiuba.algo3.modelo.continente.AmericaDelSur;
import edu.fiuba.algo3.modelo.continente.Asia;
import edu.fiuba.algo3.modelo.continente.Continente;
import edu.fiuba.algo3.modelo.continente.Europa;
import edu.fiuba.algo3.modelo.continente.Oceania;

public class Tablero {

    private final ArrayList<Pais> paises;
    private final HashMap<String, Continente> continentes = new HashMap<>();

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
        for (Pais paise : paises) {
            if (paise.obtenerFicha().esIgualA(unJugador.obtenerFicha())) {
                cantidadPaises++;
            }
        }
        return cantidadPaises;
    }

    public int obtenerCantidadPaisesJugadorEnContinente(Jugador unJugador, String unContinente){
        int cantidadPaises = 0;
        for (Pais pais : paises) {
            if (pais.continenteNombre().equalsIgnoreCase(unContinente) && pais.obtenerFicha().esIgualA(unJugador.obtenerFicha())) {
                cantidadPaises++;
            }
        }
        return cantidadPaises;
    }

    public ArrayList<Continente> obtenerContinentes(){
        return  new ArrayList<>(this.continentes.values());
    }

    public int fichasContinente(Jugador unJugador){
        int cantidadEjercitos = 0;
        ArrayList<Continente> listaContinentes = this.obtenerContinentes();
        for (Continente continente : listaContinentes) {
            cantidadEjercitos = continente.obtenerEjercitosExtra(unJugador);
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

    public ArrayList<Pais> obtenerPaises() {
        return paises;
    }

    public int obtenerCantidadPaisesDeContinente(String continente) {
        int cantidad = 0;
        for (Pais pais : paises) {
            if (pais.continenteNombre().equalsIgnoreCase(continente))
                cantidad++;
        }
        return cantidad;
    }
}
