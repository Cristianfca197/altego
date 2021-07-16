package edu.fiuba.algo3.modelo;

import com.google.gson.annotations.SerializedName;

public class Carta {
    @SerializedName("Pais")
    String pais;
    @SerializedName("Simbolo")
    String simbolo;

    //getters and setters
    public final String getPais() {
        return this.pais;
    }

    public final String getSimbolo(){
        return this.simbolo;
    }
}