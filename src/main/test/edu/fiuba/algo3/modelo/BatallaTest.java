package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BatallaTest {

    @Test
    public void test01AtaqueSeRealizaSinInconvenientes()throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(2, unPais.obtenerFicha());/*Un pais queda con 3 ejercitos*/
        otroPais.colocarEjercitos(1, unPais.obtenerFicha());/*Otro pais queda con 2 ejercitos*/
        unPais.sonLimitrofesEntre(otroPais);


        assertDoesNotThrow(() -> {batalla.combateEntre(unPais, otroPais);});
    }

    @Test
    public void test02BatallaConPaisesAliadosNoEsPosible() {
        Jugador equipoAzul = new Jugador();
        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Chile", equipoAzul);
        Batalla batalla = new Batalla();

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {batalla.combateEntre(unPais, otroPais);});
    }
    
    @Test
    public void test03BatallaConPaisesNoLimitrofesNoEsPosible() throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Colombia", equipoRojo);
        Batalla batalla = new Batalla();

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {batalla.combateEntre(unPais, otroPais);});

    }

    @Test
    public void test04BatallaConPaiseAtacanteConMenosDe2EjercitosNoEsPosible() throws ExcepcionAtaqueInvalido{
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(2, unPais.obtenerFicha());
        otroPais.colocarEjercitos(2, otroPais.obtenerFicha());
        Batalla batalla = new Batalla();

        assertThrows(ExcepcionAtaqueInvalido.class, () -> {batalla.combateEntre(unPais, otroPais);});
    }

    @Test
    public void test05BatallasIndividualesDisminuyeElEjercitoDelPaisConDadosMasChicos(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(1);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);
        assertEquals(0, otroPais.cantidadDeEjercitos());
    }
    @Test
    public void test06BatallasIndividualesEmpateDeDadosDisminuyeElEjercitoDelPaisAtacante(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);

        unPais.colocarEjercitos(1, equipoAzul.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(6);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);
        assertEquals(0, unPais.cantidadDeEjercitos());
    }

    @Test
    public void test07BatallasIndividualesAtacantePierde2EjercitosDefensorPierde1(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);

        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(2, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(4);
        dadosUnPais.add(3);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(6);
        dadosOtroPais.add(5);
        dadosOtroPais.add(1);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);

        assertEquals(2, unPais.cantidadDeEjercitos());
        assertEquals(2, otroPais.cantidadDeEjercitos());
    }

    @Test
    public void test08BatallasIndividualesGanaElAtacanteYOcupaElPais(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);
        assertEquals(unPais.obtenerFicha(), otroPais.obtenerFicha());
    }

    @Test
    public void test09BatallasIndividualesGanaElAtacanteYOcupaElPaisCantidadDeFichasEsLaCorrecta(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(2, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(6);
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);


        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);

        assertEquals(1, unPais.cantidadDeEjercitos());
        assertEquals(3, otroPais.cantidadDeEjercitos());

    }

    @Test
    public void test10BatallasIndividualesGanaElAtacantePeroNoOcupaElPais(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(4, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(6);
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);

        assertNotEquals(unPais.obtenerFicha(), otroPais.obtenerFicha());
    }

    @Test
    public void test11BatallasIndividualesGanaElAtacantePeroNoOcupaElPaisFichasDefensorSonLasCorrectas(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(4, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(6);
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais,dadosOtroPais);

        assertEquals( 2,otroPais.cantidadDeEjercitos());
    }

    @Test
    public void test12BatallasIndividualesGanaElAtacantePeroNoOcupaElPaisFichasAtacanteSonLasCorrectas(){
        Jugador equipoAzul = new Jugador();
        Jugador equipoRojo = new Jugador();
        Batalla batalla = new Batalla();

        Pais unPais = new Pais("Argentina", equipoAzul);
        Pais otroPais = new Pais("Brasil", equipoRojo);
        unPais.colocarEjercitos(3, equipoAzul.obtenerFicha());
        otroPais.colocarEjercitos(4, equipoRojo.obtenerFicha());

        ArrayList<Integer> dadosUnPais = new ArrayList<>();
        dadosUnPais.add(6);
        dadosUnPais.add(6);
        dadosUnPais.add(6);

        ArrayList<Integer> dadosOtroPais = new ArrayList<>();
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);
        dadosOtroPais.add(2);

        batalla.batallasIndividuales(unPais, otroPais, dadosUnPais, dadosOtroPais);

        assertEquals(4, unPais.cantidadDeEjercitos());
    }
}
