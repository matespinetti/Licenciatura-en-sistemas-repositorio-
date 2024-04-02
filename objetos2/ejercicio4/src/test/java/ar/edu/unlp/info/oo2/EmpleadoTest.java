package ar.edu.unlp.info.oo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTest {

        EmpleadoPlanta empleadoPlanta;
        EmpleadoPasante empleadoPasante;

        EmpleadoTemporario empleadoTemporario;

        @BeforeEach
        void setUp() throws Exception {
            empleadoPlanta = new EmpleadoPlanta(true, 2, 3);
            empleadoPasante = new EmpleadoPasante(5);
            empleadoTemporario = new EmpleadoTemporario(5, false, 2 );
        }
        @Test
        public void testSueldoPlanta() {
            assertEquals(57750, empleadoPlanta.sueldo());
        }
        @Test
        public void testSueldoPasante() {
            assertEquals(26900, empleadoPasante.sueldo());
        }
        @Test
        public void testSueldoTemporario() {
        assertEquals(22505, empleadoTemporario.sueldo());
        }

    }
