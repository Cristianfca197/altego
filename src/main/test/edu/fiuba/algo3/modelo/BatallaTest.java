package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BatallaTest {

    @Test

    public void batallaConPaisesAliadosNoEsPosible()throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Argentina", equipoAzul);
        Batalla batalla = new Batalla();

        try {
            batalla.combateEntre(unPais, otroPais);
        }
        catch (ExcepcionAtaqueInvalido e){
            System.out.println("Error no se puede atacar a un Pais aliado");
        }
    }
    @Test
    public void batallaConPaisesNoLimitrofesNoEsPosible()throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Argentina", equipoRojo);
        Batalla batalla = new Batalla();

        try {
            batalla.combateEntre(unPais, otroPais);
        }
        catch (ExcepcionAtaqueInvalido e){
            System.out.println("Error no se puede atacar a un Pais que no es limitrofe");
        }
    }

    @Test
    public void batallaConPaiseAtacanteConMenosDe2EjercitosNoEsPosible()throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Argentina", equipoRojo);
        unPais.colocarEjercitos(2, unPais.obtenerFicha());
        otroPais.colocarEjercitos(2, otroPais.obtenerFicha());
        Batalla batalla = new Batalla();

        try {
            batalla.combateEntre(unPais, otroPais);
        }
        catch (ExcepcionAtaqueInvalido e){
            System.out.println("Error no se puede atacar con un Pais con menos de 2 ejercitos");
        }

    }
}
