package edu.fiuba.algo3.modelo.objetivo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.Tablero;

public class ObjetivoOcupar implements Objetivo {

    private final String titulo;
    private final HashMap<String, Integer> continentesYCantidades;
    private final ArrayList<String> continentesAOcupar;
    private int objetivoComunCantidad;
    private int objetivoComunCantidadActual;
    private Boolean estaCumplido;
    private Integer limitrofes;
    private Jugador jugador;
 
    public ObjetivoOcupar(String titulo, ArrayList<String> continentesAOcupar, HashMap<String, Integer> continentesYCantidades) {
        this.titulo = titulo;
        this.limitrofes = continentesYCantidades.remove("Limitrofes");
        if (this.limitrofes==null) this.limitrofes = 0;

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
        
    }

    @Override
    public void asignarJugador(Jugador unJugador) {
        this.jugador = unJugador;
    }

    @Override
    public void actualizar(Juego juego) {
        Boolean obj1 = true, obj2 = true, obj3 = true;

        if (this.jugador == null) return;

        for (String c : this.continentesAOcupar) {
            if (obj1)
                obj1 = (juego.obtenerTablero().obtenerCantidadPaisesDeContinente(c) == 
                        juego.obtenerTablero().obtenerCantidadPaisesJugadorEnContinente(this.jugador, c));
        }
        
        for (Map.Entry<String, Integer> entry : continentesYCantidades.entrySet()) {
            String continente = entry.getKey();
            Integer cantidad = entry.getValue();
            if (obj2)
                obj2 = (cantidad <= juego.obtenerTablero().obtenerCantidadPaisesJugadorEnContinente(this.jugador, continente));
        }

        if (this.limitrofes > 0){
            for (Pais unPais : juego.obtenerTablero().obtenerPaises()) {
                if (unPais.perteneceA(this.jugador)){
                    int cantidadLimitrofesOcupados = 0;
                    for (Pais otroPais : unPais.obtenerLimitrofes() ) {
                        if (otroPais.perteneceA(this.jugador)) cantidadLimitrofesOcupados++;
                    }
                    if (obj3) obj3 = cantidadLimitrofesOcupados >= this.limitrofes;
                }
            }
        }

        this.objetivoComunCantidadActual = juego.obtenerTablero().obtenerCantidadPaisesJugador(this.jugador);

        this.estaCumplido = ( (obj1 && obj2 && obj3) || (this.objetivoComunCantidadActual >= this.objetivoComunCantidad));
        
    }
    
}
