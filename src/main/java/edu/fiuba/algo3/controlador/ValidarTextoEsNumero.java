package edu.fiuba.algo3.controlador;

public class ValidarTextoEsNumero {

    public boolean validarTexto(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
