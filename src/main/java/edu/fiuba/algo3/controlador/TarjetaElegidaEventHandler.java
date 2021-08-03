package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.exception.ExcepcionActivacionTarjetaInvalido;
import edu.fiuba.algo3.vista.VistaPais;
import edu.fiuba.algo3.vista.VistaTarjetaPais;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;

public class TarjetaElegidaEventHandler implements EventHandler<MouseEvent> {
    private final String pais;
    private final Juego juego;
    private final HashMap<String, VistaPais> paises;
    private final boolean esCanje;
    private final VistaTarjetaPais vista;

    public TarjetaElegidaEventHandler(String nombreTarjeta, Juego juego, HashMap<String, VistaPais> paises, boolean esCanje, VistaTarjetaPais vistaTarjetaPais){
        this.juego = juego;
        this.pais = nombreTarjeta;
        this.paises = paises;
        this.esCanje = esCanje;
        this.vista = vistaTarjetaPais;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        if(esCanje){
            if (vista.obretenerTarjetasElegidas().size() < 3 && !vista.obretenerTarjetasElegidas().contains(pais)) {
                vista.agregarTarjetaElegida(pais);
            }
        }
        else {
            try {
                juego.activarTarjetaPais(pais);
            } catch (ExcepcionActivacionTarjetaInvalido e){
                new Alerta(e.getMessage(), "Error Activación Tarjeta");
            }
            paises.get(pais).actualizar(juego.obtenerPais(pais).cantidadDeEjercitos(), juego.obtenerPais(pais).obtenerFicha().color());
        }
    }
}
