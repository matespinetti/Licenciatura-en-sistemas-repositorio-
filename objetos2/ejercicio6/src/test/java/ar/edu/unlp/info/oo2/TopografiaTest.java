package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopografiaTest {
    TopografiaAgua topografiaAgua;
    TopografiaTierra topografiaTierra;
    TopografiaMixta topografiaMixta;
    TopografiaMixta topografiaMixta2;

    TopografiaAgua topografiaAgua2;
    @BeforeEach
    public void setUp() {
        topografiaAgua = new TopografiaAgua();
        topografiaTierra = new TopografiaTierra();
        topografiaMixta = new TopografiaMixta();
        topografiaAgua2 = new TopografiaAgua();
        topografiaMixta.addTopografia(topografiaAgua);
        topografiaMixta.addTopografia(topografiaTierra);
        topografiaMixta.addTopografia(topografiaAgua);
        topografiaMixta.addTopografia(topografiaTierra);
        topografiaMixta2 = new TopografiaMixta();
        topografiaMixta2.addTopografia(topografiaAgua);
        topografiaMixta2.addTopografia(topografiaTierra);
        topografiaMixta2.addTopografia(topografiaAgua);
        topografiaMixta2.addTopografia(topografiaTierra);


    }

    // Testear proporcion de agua y tierra de uno mixto
    @Test
    public void testProporcionAguaTierraMixto() {

        assertEquals(0.5, topografiaMixta.getProporcionA());
        assertEquals(0.5, topografiaMixta.getProporcionT());
    }

    @Test
    public void testEqualsTopografia() {
        assertEquals(topografiaAgua, topografiaAgua2);
    }

    @Test
    public void testEqualsTopografiaMixta() {
        assertEquals(topografiaMixta, topografiaMixta2);
    }





}
