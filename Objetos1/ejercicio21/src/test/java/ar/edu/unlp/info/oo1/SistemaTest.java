package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SistemaTest {
    Agencia a;
    Contribuyente c;

    @BeforeEach
    void setUp(){
        a = new Agencia();
        c = new Contribuyente();

        a.agregarContribuyente(a);

    }

    @Test
    // Test embarcacion de 9 anos con valor menor a 1000000
    void testImpuesto1(){
        a.agregarEmbarcacion(new Embarcacion(LocalDate.of(2014, 9, 10), 999999,99), c);
        Assertions.assertEquals();


    }




}
