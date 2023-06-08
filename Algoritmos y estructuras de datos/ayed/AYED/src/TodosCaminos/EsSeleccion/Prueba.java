package TodosCaminos.EsSeleccion;

import tp04.ejercicio1.ArbolGeneral;

public class Prueba {
    public static void main(String[] args) {
        ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(5);
        a.agregarHijo(new ArbolGeneral<>(5));
        a.agregarHijo(new ArbolGeneral<Integer>(23));
        a.agregarHijo(new ArbolGeneral<Integer>(51));
        a.agregarHijo(new ArbolGeneral<>(123));

        ParcialSeleccion p = new ParcialSeleccion();
        System.out.println(p.esDeSeleccion(a));
    }
}
