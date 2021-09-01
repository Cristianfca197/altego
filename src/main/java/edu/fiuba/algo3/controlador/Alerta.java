package edu.fiuba.algo3.controlador;

import javafx.scene.control.Alert;

public class Alerta {

   public Alerta(String mensaje, String texto){
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Error:"+ texto);
      alert.setHeaderText(mensaje);
      alert.showAndWait();
   }
}
