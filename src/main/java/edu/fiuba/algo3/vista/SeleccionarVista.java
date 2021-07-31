package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.tipoTarjeta.Barco;
import edu.fiuba.algo3.modelo.tipoTarjeta.Canion;
import edu.fiuba.algo3.modelo.tipoTarjeta.Comodin;
import edu.fiuba.algo3.modelo.tipoTarjeta.Globo;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SeleccionarVista {

    private final Stage stage;

    public SeleccionarVista(Stage stage) {
        this.stage = stage;
    }

    public void mostrarInterfazInicial(){
        stage.setTitle("Interfaz inicial");
        VistaInicial vistaInicial = new VistaInicial(this);
        Scene escenaBienvenidos = new Scene (vistaInicial);
        stage.setScene(escenaBienvenidos);
        stage.setResizable(false);
    }
    public void mostrarInterfazColocacion(Juego juego, String nombreJugadorActual, String nombreSiguienteJugador, int ejercitosDisponibles){
        stage.setTitle("Interfaz Colocacion");
        Mapa mapaJuego = new Mapa(juego.obtenerPaises());
        VistaEtapaColocacion vistaColocacion = new VistaEtapaColocacion(mapaJuego, nombreJugadorActual, nombreSiguienteJugador, juego, this, ejercitosDisponibles);
        Scene escenaColocacion = new Scene(vistaColocacion);
        stage.setScene(escenaColocacion);
        stage.setResizable(false);

    }
    public void mostrarInterfazAtaque(Juego juego, String nombreJugadorActual, String nombreSiguienteJugador){
        Mapa mapaJuego =  new Mapa(juego.obtenerPaises());
        stage.setTitle("Interfaz ataque");
        VistaEtapaAtaque vistaAtaque = new VistaEtapaAtaque(mapaJuego, nombreJugadorActual, nombreSiguienteJugador, juego, this);
        Scene escenaAtaque = new Scene(vistaAtaque);
        stage.setScene(escenaAtaque);
        stage.setResizable(false);

    }

    public void mostrarInterfazTarjetas(){
        stage.setTitle("Interfaz Tarjetas");
        TarjetaPais tarjetaPais = new TarjetaPais(new Canion(), "Argentina");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Comodin(), "Chile");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Barco(), "Brasil");
        TarjetaPais tarjetaPais4 = new TarjetaPais(new Globo(), "Uruguay");

        ArrayList<TarjetaPais> tarjetas = new ArrayList<>();
        tarjetas.add(tarjetaPais);
        tarjetas.add(tarjetaPais2);
        tarjetas.add(tarjetaPais3);
        tarjetas.add(tarjetaPais4);

        VistaTarjetaPais vistaTarjeta = new VistaTarjetaPais(tarjetas);

        Scene escenaTarjeta = new Scene(vistaTarjeta, 1000,800);
        stage.setScene(escenaTarjeta);
        stage.setResizable(false);
    }
}
