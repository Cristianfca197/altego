package edu.fiuba.algo3.modelo.juego;

import java.util.*;

import edu.fiuba.algo3.modelo.canje.Canje;
import edu.fiuba.algo3.modelo.canje.PrimerCanje;
import edu.fiuba.algo3.modelo.exception.ExcepcionActivacionTarjetaInvalido;
import edu.fiuba.algo3.modelo.exception.ExcepcionAtaqueInvalido;
import edu.fiuba.algo3.modelo.exception.ExcepcionCanjeInvalido;

public class Jugador {
    private final Ficha ficha;
    private final MazoTarjetasPais listaTarjetas;
    private Canje canje;

    public Jugador() {

        this.ficha = new Ficha();
        this.listaTarjetas = new MazoTarjetasPais();
        this.canje = new PrimerCanje();
    }

    public void obtenerTarjeta(TarjetaPais unaTarjeta) {
        listaTarjetas.agregarTarjeta(unaTarjeta);
    }

    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais) {
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
    }

    public Ficha obtenerFicha() {
        return this.ficha;
    }

    public void colocarEjercitosCanje(Integer cantidadDeEjercitos, Pais pais) {
        pais.colocarEjercitos(cantidadDeEjercitos, this.obtenerFicha());

    }

    public int realizarCanje(ArrayList<TarjetaPais> tarjetasCanje) {//version seleccion automatica
        int ejercitosAgregar = 0;
        if (listaTarjetas.esCanjeValido()) {
            try {
                tarjetasCanje = listaTarjetas.obtenerTarjetasParaCanje();
                ejercitosAgregar = canje.realizarCanje(tarjetasCanje);
                this.canje = this.canje.actualizarCanje();
            } catch (ExcepcionCanjeInvalido excepcionCanjeInvalido) {
                System.out.println("Canje invalido, cantidad de tarjetas incorrecta");
            }

        }
        return ejercitosAgregar;
    }

    public int canjearTarjetas(ArrayList<TarjetaPais> tarjetas) {//version seleccion manual
        int ejercitosAgregar = 0;

        try {
            ejercitosAgregar = canje.realizarCanje(tarjetas);
            this.canje = this.canje.actualizarCanje();
        } catch (ExcepcionCanjeInvalido excepcionCanjeInvalido) {
            System.out.println("Canje invalido, cantidad de tarjetas incorrecta");
        }

        return ejercitosAgregar;
    }

    public ArrayList<TarjetaPais> ocuparPaises() {
        ArrayList<TarjetaPais> tarjetas = this.listaTarjetas.obtenerTarjetas();
        for (int i = 0; i < tarjetas.size(); i++) {
            tarjetas.get(i).obtenerPais().asignarJugador(this);
        }
        return tarjetas;
    }

    public void obtenerEjercitosDeCanje(int cantidadDeEjercitos, ArrayList<TarjetaPais> tarjetasCanje) {
        cantidadDeEjercitos += this.realizarCanje(tarjetasCanje);
    }

    public void activarTarjetaPais(TarjetaPais unaTarjetaPais) {
        try {
            unaTarjetaPais.activarTarjeta(this);
        } catch (ExcepcionActivacionTarjetaInvalido e) {
            System.out.println("Activacion invalida vuelva a intentar");
        }
    }

    public void hacerAtaques(Pais paisAtacante, ArrayList<Pais> paisesQuePuedeAtacarElJugador) {//Se quitarian las excepciones como un refactor
        Pais paisDefensor = paisesQuePuedeAtacarElJugador.get(0);//Ataca al primero por default, el jugador selecciona a cual
        try {
            paisAtacante.atacarA(paisDefensor);
        } catch (ExcepcionAtaqueInvalido excepcionAtaqueInvalido) {
            excepcionAtaqueInvalido.printStackTrace();
        }

    }

    public Canje obtenerCanje() {
        return this.canje;
    }

    public boolean tieneFicha(Ficha unaficha) {
        return this.ficha.esIgualA(unaficha);
    }
}
