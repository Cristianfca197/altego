package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dados {

   private final ArrayList<Integer> listaDados;

   public Dados (Pais pais) {
      int cantDados = pais.cantidadDeEjercitos();
      this.listaDados= new ArrayList<>();

      if(cantDados > 3) { cantDados = 3; }

      for(int i = 0; i < cantDados; i++) {
         Integer num = (int)Math.floor(Math.random()*(6)+1);
         this.listaDados.add(num);
      }
      Collections.sort(this.listaDados,Collections.reverseOrder());
   }

   public ArrayList<Integer> obtenerDados() { return this.listaDados; }


}
