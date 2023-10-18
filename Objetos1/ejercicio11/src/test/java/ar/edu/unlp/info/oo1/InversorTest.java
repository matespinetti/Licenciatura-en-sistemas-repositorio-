package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class InversorTest {
    @Test
    public void testValorActual(){
        PlazoFijo p = new PlazoFijo(LocalDate.of(2023, 10, 3), 1000, 0.10);
        InversionEnAcciones i = new InversionEnAcciones("YPF", 15, 200);
        Inversor inv = new Inversor("Mateo");
        inv.agregarInversion(p);
        inv.agregarInversion(i);
        Assertions.assertEquals(4210, inv.valorActual());

    }
}
