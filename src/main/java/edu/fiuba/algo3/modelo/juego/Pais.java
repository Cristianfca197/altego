package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.continente.Continente;
import edu.fiuba.algo3.modelo.exception.ExcepcionAtaqueInvalido;
import edu.fiuba.algo3.modelo.exception.ExcepcionCantidadInvalida;
import edu.fiuba.algo3.modelo.exception.ExcepcionPaisInvalido;

import java.util.ArrayList;

public class Pais {
    private final String nombre;
    private Integer ejercitos;
    private Ficha ficha;
    private final ArrayList<Pais> paisesLimitrofes;
    private Continente continente;

    //pais inicializa sin ejercitos al recibir la tarjeta un jugador le agrega uno marcandolo como suyo
    public Pais(String nombre){
        this.nombre = nombre;
        this.ejercitos = 0;
        this.paisesLimitrofes = new ArrayList<>();
    }
    public void asignarJugador(Jugador unJugador){
        this.ejercitos = 1;
        this.ficha = unJugador.obtenerFicha();
    }

    public void colocarEjercitos(Integer unaCantidadDeEjercitos, Ficha unaFicha){
        if(this.ficha.esIgualA(unaFicha)) {
            this.ejercitos += unaCantidadDeEjercitos;
        }else{ throw new ExcepcionPaisInvalido("El pais seleccionado no es un pais propio");}
    }
    public int cantidadDeEjercitos(){
        return ejercitos;
    }

    public Ficha obtenerFicha(){
        return this.ficha;
    }

    public void eliminarEjercito() {
        this.ejercitos = this.ejercitos -1 ;
    }

    public void cambiarFicha(Ficha nuevaFicha) {this.ficha = nuevaFicha;}

    public void ocuparPais(Pais paisNuevo, int cantidadEjercito) {
        if(paisNuevo.estaVacio()) {

            this.ejercitos -= cantidadEjercito;
            paisNuevo.cambiarFicha(this.obtenerFicha());
            paisNuevo.colocarEjercitos(cantidadEjercito, this.obtenerFicha());
        }
    }

    public boolean estaVacio() { return cantidadDeEjercitos() == 0;}

    public void sonLimitrofesEntre(Pais otroPais) {
        if(esLimitrofeCon(otroPais)) return;

        this.paisesLimitrofes.add(otroPais);
        otroPais.paisesLimitrofes.add(this);
    }

    public boolean esLimitrofeCon(Pais otroPais) { return otroPais.paisesLimitrofes.contains(this);}

    public void atacarA(Pais paisEnemigo) throws ExcepcionAtaqueInvalido {

        if (this.obtenerFicha().esIgualA(paisEnemigo.obtenerFicha())){
            throw new ExcepcionAtaqueInvalido("Ataque entre paises aliados no es posible");
        }
        if(!(this.esLimitrofeCon(paisEnemigo))){
            throw new ExcepcionAtaqueInvalido("Ataque entre paises no limitrofes no es posible");
        }
        if(this.cantidadDeEjercitos() < 2){
            throw new ExcepcionAtaqueInvalido("Pais atacante con menos de 2 ejercitos no puede atacar");
        }
        Batalla batalla = new Batalla();
        batalla.combateEntre(this, paisEnemigo);
    }

    public String obtenerNombre(){return this.nombre;}

    public void perteneceAlContinente(Continente continente) {
        this.continente = continente;
        continente.aniadirPais(this);
    }

    public String continenteNombre() {
        return this.continente.obtenerNombre();
    }

    public boolean perteneceA(Jugador unJugador) {
        return unJugador.tieneFicha(this.ficha);
    }

    public ArrayList<Pais> obtenerLimitrofes(){
        return this.paisesLimitrofes;
    }

    public void eliminarEjercitos(int cantidadEjercitos) {
        if (this.ejercitos == 1){
            throw new ExcepcionCantidadInvalida("No es posible tranferir con 1 ejercito.");
        }
        if(cantidadEjercitos >= this.ejercitos){
            throw new ExcepcionCantidadInvalida("Seleccione una cantidad entre " + (this.ejercitos - 1) + " y 0." );
        }
        this.ejercitos -= cantidadEjercitos;
    }
}
