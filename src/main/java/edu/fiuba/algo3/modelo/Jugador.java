package edu.fiuba.algo3.modelo;

import java.util.*;

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

    public void colocarEjercitosDeCanje(int cantidadDeEjercitos, ArrayList<TarjetaPais> tarjetasCanje) { //para version final automatizada
        System.out.println("Desea activar una tarjeta de pais?");
        cantidadDeEjercitos += this.realizarCanje(tarjetasCanje); //falta devolver al juego las tarjetas usadas en canje x eso se rompia
        //si elige el jugador el metodo es canjearTarjetas
        // elegir q ejercitos pedir
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

    public Pais escogerUnPais(ArrayList<Pais> listaPaises) {//Devuelve el primer pais que encuentra del jugador
        int i = 0;
        while (listaPaises.get(i).obtenerFicha() != this.obtenerFicha()) {
            i++;
        }
        return listaPaises.get(i);
    }

    public Pais escogerUnPaisEnemigo(ArrayList<Pais> paisesLimitrofes) {//Devuelve el primer pais enemigo
        for (Pais pais : paisesLimitrofes) {
            if (this.obtenerFicha() != pais.obtenerFicha()) {
                return pais;
            }
        }
        return paisesLimitrofes.get(0);
    }

    public boolean pasarTurno() {
        return true;
    }

    public void atacarDeA(Pais paisAtacante, Pais paisDefensor) {
        paisAtacante.atacarA(paisDefensor);

    }
}
