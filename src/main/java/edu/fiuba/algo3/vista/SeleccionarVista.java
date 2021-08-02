package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

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
    public void mostrarInterfazReagrupar(Juego juego, String nombreJugadorActual, String nombreSiguienteJugador){
        Mapa mapaJuego =  new Mapa(juego.obtenerPaises());
        stage.setTitle("Interfaz reagrupar");
        VistaEtapaReagrupar vistaEtapaReagrupar = new VistaEtapaReagrupar(mapaJuego, nombreJugadorActual, nombreSiguienteJugador, juego, this);
        Scene escenaAtaque = new Scene(vistaEtapaReagrupar);
        stage.setScene(escenaAtaque);
        stage.setResizable(false);

    }
    public void mostrarInterfazTarjetas(Juego juego, Stage otroStage, HashMap<String, VistaPais> paises){
        otroStage.setTitle("Interfaz Tarjetas");
        ArrayList<TarjetaPais> tarjetas = juego.obtenerJugadorJugando().obtenerTarjetas();


        VistaTarjetaPais vistaTarjeta = new VistaTarjetaPais(tarjetas, juego, paises);

        Scene escenaTarjeta = new Scene(vistaTarjeta, 1000,800);
        otroStage.setScene(escenaTarjeta);
        otroStage.show();
    }
}
