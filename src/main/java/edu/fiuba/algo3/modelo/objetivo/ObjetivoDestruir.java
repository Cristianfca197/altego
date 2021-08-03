package edu.fiuba.algo3.modelo.objetivo;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Tablero;

public class ObjetivoDestruir implements Objetivo {

    private final String titulo;
    private final String equipoADestruir;
    private int objetivoComunCantidad;
    private Boolean estaCumplido = false;
    private Jugador jugador;

    public ObjetivoDestruir(String titulo, String equipoADestruir){
        this.titulo = titulo;
        this.equipoADestruir = equipoADestruir;

    }

    @Override
    public void asignarJugador(Jugador unJugador) {
        this.jugador = unJugador;
    }

    @Override
    public Boolean estaCumplido() {
        return estaCumplido;
    }

    @Override
    public String obtenerTipo() {
        return "Destruir";
    }

    @Override
    public Integer paisesAConquistar(String string) {
        // No debe conquistar paises
        return 0;
    }

    @Override
    public ArrayList<String> continentesAOcupar() {
        return null;
    }

    @Override
    public String equipoADestruir() {
        return this.equipoADestruir;
    }

    @Override
    public String titulo() {
        return this.titulo;
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
    public void equipoDestruido(String color, Juego unJuego){
        this.estaCumplido = (color.equals(this.equipoADestruir));

        if (!unJuego.existeColor(color)){
            this.estaCumplido = unJuego.siguienteJugador(this.jugador).color().equalsIgnoreCase(color);
        }
        
    }

    @Override
    public void paisesConquistados(Tablero tablero, Jugador unJugador) {
        
    }

    @Override
    public void actualizar(Juego juego) {

        if (this.jugador == null) return;

        Jugador unJugador = juego.obtenerJugadorPorColor(this.equipoADestruir);

        if (unJugador == null){
            unJugador = juego.siguienteJugador(this.jugador);
        }

        int tieneTreintaOMasPaises = juego.obtenerTablero().obtenerCantidadPaisesJugador(this.jugador);

        this.estaCumplido = (!juego.tienePaises(unJugador)) || (tieneTreintaOMasPaises >= this.objetivoComunCantidad);
    }

}
