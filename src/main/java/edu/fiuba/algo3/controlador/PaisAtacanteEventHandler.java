package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.VistaEtapaAtaque;
import edu.fiuba.algo3.vista.VistaPais;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PaisAtacanteEventHandler implements EventHandler<MouseEvent> {
    private final VistaPais pais;
    private final VistaEtapaAtaque vista;
    private final Juego juego;

    public PaisAtacanteEventHandler(VistaPais pais, VistaEtapaAtaque vista, Juego juego){
        this.pais = pais;
        this.vista = vista;
        this.juego = juego;
    }
    @Override
    public void handle(MouseEvent mouseEvent){
        if (vista.obtenerPaisAtacante() == null){
            vista.paisAtacanteElegido(pais);
        }
        else{
            juego.atacarDesdeA(vista.obtenerPaisAtacante().obtenerNombre(), pais.obtenerNombre());
            pais.actualizar(juego.obtenerPais(pais.obtenerNombre()).cantidadDeEjercitos(), juego.obtenerPais(pais.obtenerNombre()).obtenerFicha().color());
            vista.obtenerPaisAtacante().actualizar(juego.obtenerPais(vista.obtenerPaisAtacante().obtenerNombre()).cantidadDeEjercitos(), juego.obtenerPais(vista.obtenerPaisAtacante().obtenerNombre()).obtenerFicha().color());
            vista.ataqueRealizado();
        }

    }
}
