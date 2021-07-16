package edu.fiuba.algo3.modelo;

import java.util.*;

public class Juego { 
  
    private Dictionary<String, TipoTarjeta> tarjetasDePais;
    private ArrayList<Jugador> listaJugadores;
    private CargarArchivo carga = new CargarArchivo();

    public Juego(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            this.listaJugadores.add(new Jugador());
        }
    }

    public void establecerTarjetas(){
        if(!carga.cargarPaises(tarjetasDePais)) {
            //salta una exepcion
        }

    }

    public Integer cantidadDeJugadores() {
        return this.listaJugadores.size();
    }
}