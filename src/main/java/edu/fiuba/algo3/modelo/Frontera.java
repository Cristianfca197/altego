package edu.fiuba.algo3.modelo;

import com.google.gson.annotations.SerializedName;
import java.util.*;

public class Frontera {
    @SerializedName("Pais")
    String pais;
    @SerializedName("Continente")
    String continente;
    @SerializedName("Limita con")
    String limitrofes;

    //getters and setters
    public final String getPais() {
        return this.pais;
    }

    public final String getContinente(){
        return this.continente;
    }

    public final ArrayList<String> getLimitrofes(){
        String[] paisesLimitrofes = this.limitrofes.split(",");
        ArrayList list = new ArrayList(Arrays.asList(paisesLimitrofes));
        return list;
    };
}
