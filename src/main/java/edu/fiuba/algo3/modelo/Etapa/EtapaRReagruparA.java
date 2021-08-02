package edu.fiuba.algo3.modelo.Etapa;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.exception.ExcepcionCantidadInvalida;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

abstract class EtapaRReagruparA implements EtapaR{
    public final Juego juego;
    public int ejercitosColocados;
    public int cantidadEjercitos;

    public EtapaRReagruparA(Juego juego){
            this.juego = juego;
        }
        @Override
        public void colocarEjercitos(Jugador jugadorActual, Pais pais, int cantidad) {
            if((ejercitosColocados + cantidad ) <= cantidadEjercitos) {
                jugadorActual.colocarEjercitosEn(cantidad, pais);
                ejercitosColocados += cantidad;
            }else throw new ExcepcionCantidadInvalida("Ingrese una cantidad entre " +
                    (cantidadEjercitos - ejercitosColocados) + " y 0");
        }

        @Override
        public void AtacarCon(Jugador jugadorActual, Pais atacante, Pais defensor) {

        }

        @Override
        public void transferirEjercitos(Jugador jugadorActual, Pais aliado1, Pais aliado2, int cantidadEjercitos) {

        }

        @Override
        public boolean estaTerminada() {
            if(this.ejercitosColocados == this.cantidadEjercitos){
                ejercitosColocados = 0;
                return true;
            }
            return false;
        }

        @Override
        public void establecerCantidadEjercitos(int cantidadEjercitosDisponibles) {
            if(this.cantidadEjercitos == 0) {
                this.cantidadEjercitos = cantidadEjercitosDisponibles;
            }
        }

        @Override
        public int obtenerCantidadEjercitos() {
            return cantidadEjercitos - ejercitosColocados;
        }

        @Override
        public abstract EtapaR pasarEtapa();
}
