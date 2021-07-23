package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;
import java.util.Collections;

public class Dados {

   private final ArrayList<Integer> listaDados;

   public Dados (int cantidadDeEjercitos) {
      this.listaDados= new ArrayList<>();

      for(int i = 0; i < cantidadDeEjercitos && i < 3; i++) {
         Integer num = (int)Math.floor(Math.random()*(6)+1);
         this.listaDados.add(num);
      }
      Collections.sort(this.listaDados,Collections.reverseOrder());
   }

   public ArrayList<Integer> obtenerDados() { return this.listaDados; }


}
