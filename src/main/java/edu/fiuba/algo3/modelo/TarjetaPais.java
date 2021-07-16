package edu.fiuba.algo3.modelo;

public class TarjetaPais {

    private TipoTarjeta tipo;
    private Pais pais;
    private boolean estaActivada;

    public TarjetaPais(TipoTarjeta unTipo, String unPais) {
        this.pais = new Pais(unPais);
        this.tipo = unTipo;
        this.estaActivada = false;
    }
    public TipoTarjeta obtenerTipo(){ return  this.tipo;}

    public Pais obtenerPais(){
        return this.pais;
    }

    public boolean esDelMismoTipo(TarjetaPais unaTarjeta){
        return (this.tipo == unaTarjeta.obtenerTipo());
    }
    public boolean paisEsDe(Jugador unJugador){
        return (this.pais.obtenerFicha().esIgualA(unJugador.obtenerFicha()));
    }
    public void activarTarjeta(Jugador jugador) throws ExcepcionActivacionTarjetaInvalido {
        if (this.obtenerPais().obtenerFicha().esIgualA(jugador.obtenerFicha()) && !(this.estaActivada)){
            jugador.colocarEjercitosEn(2,this.obtenerPais());
            this.estaActivada = true;
        }
        else{
            throw new ExcepcionActivacionTarjetaInvalido("El pais no esta en posesion del jugador");
        }
    }
}
