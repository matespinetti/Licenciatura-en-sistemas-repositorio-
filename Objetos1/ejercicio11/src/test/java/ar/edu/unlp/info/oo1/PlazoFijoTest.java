package ar.edu.unlp.info.oo1;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PlazoFijoTest {
    @BeforeEach
    public void setUp(){

    }
    @Test
    public void testValorActual() {
        PlazoFijo p = new PlazoFijo(LocalDate.of(2023, 10, 3), 1000, 0.10);

        Assertions.assertEquals(1210.00,p.valorActual());



    }


}
