package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.HashMap;

public class MazoTarjetasPais {

    private final HashMap<String, ArrayList<TarjetaPais>> tarjetas;

    public MazoTarjetasPais(){
        this.tarjetas = new HashMap<>();
        this.tarjetas.put("Comodin", new ArrayList<>());
        this.tarjetas.put("Canion", new ArrayList<>());
        this.tarjetas.put("Barco", new ArrayList<>());
        this.tarjetas.put("Globo", new ArrayList<>());
    }
    public void agregarTarjeta(TarjetaPais unaTarjeta){
        this.tarjetas.get(unaTarjeta.obtenerTipo().obtenerNombre()).add(unaTarjeta);
    }

    public boolean esCanjeValido(){
        Integer cantidadCaniones = this.tarjetas.get("Canion").size();
        Integer cantidadBarcos = this.tarjetas.get("Barco").size();
        Integer cantidadGlobos = this.tarjetas.get("Globo").size();
        Integer cantidadComodines = this.tarjetas.get("Comodin").size();

        if(this.cantidadCartas()<3){
            return false;
        } else if(this.hayPorLoMenosTresTarjetasIguales(cantidadCaniones,cantidadGlobos, cantidadBarcos, cantidadComodines)){
            return true;
        }else if(hayPorLoMenosDosIgualesYUnComodin(cantidadCaniones,cantidadGlobos, cantidadBarcos, cantidadComodines)){
            return true;
        }
        else if (hayPorLoMenosTresTarjetasDistintas(cantidadCaniones, cantidadGlobos, cantidadBarcos, cantidadComodines)){
            return true;
        }else if(hayPorLoMenosDosTarjetasDistintasYUnComodin(cantidadCaniones, cantidadGlobos, cantidadBarcos, cantidadComodines)){
            return true;
        } else if(hayPorLoMenosDosComodinesYOtraCarta(cantidadCaniones, cantidadGlobos, cantidadBarcos, cantidadComodines)) {
            return true;
        }
        // ver de mejorarla xq esta fea
        return false;
    }

    private int cantidadCartas() {
        int totalCartas = 0;
        for (ArrayList tipos: tarjetas.values()){totalCartas += tipos.size();}
        return totalCartas;
    }

    public ArrayList<TarjetaPais> obtenerTarjetas() {
        ArrayList<TarjetaPais> tarjetaPais = new ArrayList<>();
        for(ArrayList tipos: tarjetas.values()){
            for(Object tarjetasPaises: tipos){
                tarjetaPais.add((TarjetaPais) tarjetasPaises);
            }
        }
       return tarjetaPais;
    }

    public ArrayList<TarjetaPais> obtenerTarjetasParaCanje() {
        ArrayList<TarjetaPais> tarjetasParaCanje = new ArrayList<>();

        for(ArrayList tipos: tarjetas.values()){
            if (tipos.size() == 3){
                while(tipos.size() != 0){tarjetasParaCanje.add((TarjetaPais) tipos.remove(0));}
                return tarjetasParaCanje;
            }
        }
        if(tarjetas.get("Comodin").size() > 0){tarjetasParaCanje = tarjetas.remove("Comodin");}
        
        while (tarjetasParaCanje.size() != 3) {
            for(ArrayList tipos: tarjetas.values()){
                while(tipos.size() != 0 && tarjetasParaCanje.size() != 3) {
                    tarjetasParaCanje.add((TarjetaPais) tipos.remove(0));
                }
            }
        }
        /*
        for(ArrayList tipos:tarjetas.values()) {
            if(tipos.size() != 0){tarjetasParaCanje.add((TarjetaPais) tipos.remove(0));}
        }
            pisa lo de arriba
        */

        return tarjetasParaCanje;
    }

    private Boolean hayPorLoMenosTresTarjetasIguales(Integer caniones, Integer globos, Integer barcos, Integer comodines) {
        return caniones >= 3 || globos >= 3 || barcos >= 3;
    }

    private Boolean hayPorLoMenosDosIgualesYUnComodin(Integer caniones, Integer globos, Integer barcos, Integer comodines) {
        return ((caniones ==2 || globos == 2 || barcos ==2) && comodines >= 1);
    }
    
    private Boolean hayPorLoMenosTresTarjetasDistintas(Integer caniones, Integer globos, Integer barcos, Integer comodines) {
        return (barcos >=1 && globos >= 1 && caniones >= 1);
    }

    private Boolean hayPorLoMenosDosTarjetasDistintasYUnComodin(Integer caniones, Integer globos, Integer barcos, Integer comodines) {
        return ((barcos >=1 || globos >= 1 || caniones >= 1) && comodines >= 1);
    }

    private Boolean hayPorLoMenosDosComodinesYOtraCarta(Integer caniones, Integer globos, Integer barcos, Integer comodines) {
        return ((barcos >=1 || globos >= 1 || caniones >= 1) && comodines >= 2);
    }
}
