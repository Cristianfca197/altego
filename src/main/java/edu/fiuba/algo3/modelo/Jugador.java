package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Jugador {
    private final Ficha ficha;
    private final MazoTarjetasPais listaTarjetas;
    private Canje canje;

    public Jugador(){

        this.ficha = new Ficha();
        this.listaTarjetas = new MazoTarjetasPais();
        this.canje =  new PrimerCanje();
    }

    public void obtenerTarjeta(TarjetaPais unaTarjeta){
        listaTarjetas.agregarTarjeta(unaTarjeta);
    }

    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais){
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
    }
    public Ficha obtenerFicha(){
        return this.ficha;
    }

    public void colocarEjercitosCanje(Integer cantidadDeEjercitos, Pais pais){
        pais.colocarEjercitos(cantidadDeEjercitos, this.obtenerFicha());

    }
    public int realizarCanje() {
        int ejercitosAgregar = 0;
        if (listaTarjetas.esCanjeValido()) {
            ejercitosAgregar = canje.realizarCanje(listaTarjetas.obtenerTarjetasParaCanje());
        }
        this.canje = this.canje.actualizarCanje();
        return ejercitosAgregar;
    }
    public ArrayList<TarjetaPais> ocuparPaises(){
        ArrayList<TarjetaPais> tarjetas = this.listaTarjetas.obtenerTarjetas();
        for (int i = 0; i < tarjetas.size() ; i++) {
            tarjetas.get(i).obtenerPais().asignarJugador(this);
        }
        return tarjetas;
    }
    public void colocarEjercitos(int cantidadDeEjercitos){
       // System.out.println("Jugador:" + this.nombre);
        System.out.println("Desea activar una tarjeta de pais?");
        cantidadDeEjercitos += this.realizarCanje();
        //this.activarTarjetaPais();
        // elegir q ejercitos pedir
    }
    public void activarTarjetaPais(TarjetaPais unaTarjetaPais){
        try {
            unaTarjetaPais.activarTarjeta(this);
        }
        catch (ExcepcionActivacionTarjetaInvalido e){
            System.out.println("Activacion invalida vuelva a intentar");
        }

    }
    public void hacerAtaques(Pais pais, HashMap<String, ArrayList<Pais>> paisesQuePuedeAtacarElJugador) {
        //Decidir con cual atacar y a cual
        //hacer el ataque, seguir atacando si se desea
        //Depende de los respuestas del jugador
        Pais unPais = paisesQuePuedeAtacarElJugador.get(pais.obtenerNombre()).get(0);
        try { pais.atacarA(unPais); } catch (ExcepcionAtaqueInvalido excepcionAtaqueInvalido) { excepcionAtaqueInvalido.printStackTrace(); }
    }
}
