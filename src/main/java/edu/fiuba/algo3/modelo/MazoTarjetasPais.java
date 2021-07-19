package edu.fiuba.algo3.modelo;

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
        if(this.tarjetas.get("Canion").size() >= 3 || this.tarjetas.get("Globo").size() >= 3 || this.tarjetas.get("Barco").size() >= 3){
            return true;
        }else if((this.tarjetas.get("Canion").size() ==2 || this.tarjetas.get("Globo").size() == 2 || this.tarjetas.get("Barco").size() ==2) && this.tarjetas.get("Comodin").size() >= 1){
            return true;
        }
        else if (this.tarjetas.get("Barco").size() >=1 && this.tarjetas.get("Globo").size() >= 1 && this.tarjetas.get("Canion").size() >= 1){
            return true;
        }else if((this.tarjetas.get("Barco").size() >=1 || this.tarjetas.get("Globo").size() >= 1 || this.tarjetas.get("Canion").size() >= 1) && this.tarjetas.get("Comodin").size() >= 2){
            return true;
        }
        // ver de mejorarla xq esta fea
        else return false;
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
        ArrayList<TarjetaPais> tarjetaPais = new ArrayList<>();
        for(ArrayList tipos: tarjetas.values()){
            if (tipos.size() == 3){
                while(tipos.size() != 0){tarjetaPais.add((TarjetaPais) tipos.remove(0));}
            }
        }
        if(tarjetas.get("Comodin").size() > 0){tarjetaPais = tarjetas.remove("Comodin");}
        while (tarjetaPais.size() != 3) {
            for(ArrayList tipos: tarjetas.values()){
                while(tipos.size() != 0 && tarjetaPais.size() != 3) {
                    tarjetaPais.add((TarjetaPais) tipos.remove(0));
                }
            }
        }
        for(ArrayList tipos:tarjetas.values()) {
            if(tipos.size() != 0){tarjetaPais.add((TarjetaPais) tipos.remove(0));}
        }
        return tarjetaPais;
    }
}
