package edu.fiuba.algo3.modelo;

import java.util.*;

public class Juego { 
  
    private Dictionary<String, TipoTarjeta> tarjetasDePais;
    private ArrayList<Jugador> listaJugadores;

    public Juego(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            this.listaJugadores.add(new Jugador());
        }
    }

    public void establecerTarjetas(){

        this.tarjetasDePais.put("Argentina", new Canion());
        this.tarjetasDePais.put("Brasil", new Canion());

    }

    public Integer cantidadDeJugadores() {
        return this.listaJugadores.size();
    }
}