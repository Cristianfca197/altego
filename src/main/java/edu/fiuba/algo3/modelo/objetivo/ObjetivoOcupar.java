package edu.fiuba.algo3.modelo.objetivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.Ficha;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;

public class ObjetivoOcupar implements Objetivo {

    private String titulo;
    private HashMap<String, Integer> continentesYCantidades;
    private ArrayList<String> continentesAOcupar;
    private int objetivoComunCantidad;
    private Boolean estaCumplido;
    private Integer limitrofes;
    private Jugador jugador;
 
    public ObjetivoOcupar(String titulo, ArrayList<String> continentesAOcupar, HashMap<String, Integer> continentesYCantidades) {
        this.titulo = titulo;
        this.limitrofes = continentesYCantidades.remove("Limitrofes");
        this.continentesYCantidades = continentesYCantidades;
        this.continentesAOcupar = continentesAOcupar;
    }

    @Override
    public Integer paisesAConquistar(String continente){
        return continentesYCantidades.get(continente);
    }

    @Override
    public Boolean estaCumplido() {
        return this.estaCumplido;
    }

    @Override
    public String obtenerTipo() {
        return "Ocupar";
    }

    @Override
    public ArrayList<String> continentesAOcupar() {
        return this.continentesAOcupar;
    }

    @Override
    public String equipoADestruir() {
        return null;
    }

    @Override
    public String titulo() {
        return this.titulo();
    }

    @Override
    public void establecerObjetivoComun(int cantidad) {
        this.objetivoComunCantidad = cantidad;
    }

    @Override
    public int cantidadObjetivoComun() {
        return this.objetivoComunCantidad;
    }

    @Override
    public void equipoDestruido(String string, Juego juego){
        
    }

    @Override
    public void paisesConquistados(Tablero tablero, Jugador unJugador) {
        Boolean obj1 = true, obj2 = true, obj3 = true;
        for (String continente : this.continentesAOcupar) {
            obj1 = (tablero.obtenerContinente(continente).obtenerCantidadPaises() == 
                                 tablero.obtenerCantidadPaisesJugadorEnContinente(unJugador, continente));
        }
        
        for (Map.Entry<String, Integer> entry : continentesYCantidades.entrySet()) {
            String continente = entry.getKey();
            Integer cantidad = entry.getValue();
            obj2 = (cantidad <= tablero.obtenerCantidadPaisesJugadorEnContinente(unJugador, continente));
        }

        for (Pais unPais : tablero.obtenerPaises()) {
            if (unPais.perteneceA(unJugador)){
                Integer cantidadLimitrofesOcupados = 0;
                for (Pais otroPais : unPais.obtenerLimitrofes() ) {
                    if (otroPais.perteneceA(unJugador)) cantidadLimitrofesOcupados++;
                }
                if (cantidadLimitrofesOcupados >= 3) obj3 = true;
            }
        }
        this.estaCumplido = obj1 && obj2 && obj3;
    }

    @Override
    public void asignarJugador(Jugador unJugador) {
        this.jugador = unJugador;
    }
    
}
