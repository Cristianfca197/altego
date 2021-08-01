package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaPais;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;

public class TarjetaElegidaEventHandler implements EventHandler<MouseEvent> {
    private final String pais;
    private final Juego juego;
    private final HashMap<String, VistaPais> paises;

    public TarjetaElegidaEventHandler(String nombreTarjeta, Juego juego, HashMap<String, VistaPais> paises){
        this.juego = juego;
        this.pais = nombreTarjeta;
        this.paises = paises;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        juego.activarTarjetaPais(pais);
        paises.get(pais).actualizar(juego.obtenerPais(pais).cantidadDeEjercitos(),juego.obtenerPais(pais).obtenerFicha().color() );
    }
}
