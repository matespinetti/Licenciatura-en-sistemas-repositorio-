package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversionEnAccionesTest {
    @BeforeEach
    public void setUp(){

    }

    @Test
    public void testValorActual(){
        InversionEnAcciones i = new InversionEnAcciones("YPF", 15, 200);
        Assertions.assertEquals(3000, i.valorActual());

    }
}
