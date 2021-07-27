package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.canje.PrimerCanje;
import edu.fiuba.algo3.modelo.canje.SegundoCanje;
import edu.fiuba.algo3.modelo.canje.TresOMasCanjes;
import edu.fiuba.algo3.modelo.exception.ExcepcionCanjeInvalido;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.tipoTarjeta.Barco;
import edu.fiuba.algo3.modelo.tipoTarjeta.Canion;
import edu.fiuba.algo3.modelo.tipoTarjeta.Comodin;
import edu.fiuba.algo3.modelo.tipoTarjeta.Globo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CanjeTest {
    @Test
    public void test01CanjeDeTresPaisesConElMismoSimboloEsPosible() throws ExcepcionCanjeInvalido{
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();

        assertEquals(4, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test02CanjeDeTresPaisesConDistintoSimboloEsPosible () throws ExcepcionCanjeInvalido{
        Globo globo = new Globo();
        Barco barco = new Barco();
        Canion canion = new Canion();

        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(barco, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(canion, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();

        assertEquals(4, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test03CanjeDeTresPaisesConSoloDosSimbolosIgualesNoEsPosible () throws ExcepcionCanjeInvalido{
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(new Barco(), "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();

        assertThrows(ExcepcionCanjeInvalido.class, () -> canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test04SegundoCanjeDeTresPaisesConElMismoSimboloEsPosible () throws ExcepcionCanjeInvalido{
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        SegundoCanje canje = new SegundoCanje();

        assertEquals(7, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test05TresOMasCanjesDeTresPaisesConElMismoSimboloEsPosible () throws ExcepcionCanjeInvalido{
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        TresOMasCanjes canje = new TresOMasCanjes();

        assertEquals(10, canje.realizarCanje(listaDeTarjetas));
    }
    @Test
    public void test06CuartoCanjeDeTresPaisesConElMismoSimboloEsPosible () throws ExcepcionCanjeInvalido{
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        TresOMasCanjes canje = new TresOMasCanjes();
        canje.realizarCanje(listaDeTarjetas);//Tercer Canje
        canje.actualizarCanje();

        assertEquals(15, canje.realizarCanje(listaDeTarjetas));//Cuarto Canje
    }
    @Test
    public void test07CuartoYQuintoCanjeDeTresPaisesConElMismoSimboloEsPosible () throws ExcepcionCanjeInvalido{
        Globo globo = new Globo();
        TarjetaPais primertarjeta = new TarjetaPais(globo, "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(globo, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(globo, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        TresOMasCanjes canje = new TresOMasCanjes();
        canje.realizarCanje(listaDeTarjetas);//Tercer Canje
        canje.actualizarCanje();

        canje.realizarCanje(listaDeTarjetas);//Cuarto Canje
        canje.actualizarCanje();

        assertEquals(20, canje.realizarCanje(listaDeTarjetas));//Quinto Canje
    }
    @Test
    public void test08PrimerCanjeDeTresPaisesConSimboloYDosComodinesEsPosible () throws ExcepcionCanjeInvalido{
        Comodin comodin = new Comodin();
        TarjetaPais primertarjeta = new TarjetaPais(new Globo(), "Chile");
        TarjetaPais segundaTarjeta = new TarjetaPais(comodin, "Inglaterra");
        TarjetaPais terceTarjeta = new TarjetaPais(comodin, "Japon");
        ArrayList <TarjetaPais> listaDeTarjetas = new ArrayList<>();
        listaDeTarjetas.add(primertarjeta);
        listaDeTarjetas.add(segundaTarjeta);
        listaDeTarjetas.add(terceTarjeta);
        PrimerCanje canje = new PrimerCanje();
        canje.realizarCanje(listaDeTarjetas);
        assertEquals(4, canje.realizarCanje(listaDeTarjetas));
    }

}
