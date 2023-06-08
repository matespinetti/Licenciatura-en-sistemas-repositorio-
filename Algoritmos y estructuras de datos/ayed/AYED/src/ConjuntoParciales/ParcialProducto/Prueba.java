package ConjuntoParciales.ParcialProducto;

import tp04.ejercicio1.ArbolGeneral;

public class Prueba {

    public static void main(String[] args) {
        ArbolGeneral<Integer> arbol = new ArbolGeneral<>(500);
        arbol.agregarHijo(new ArbolGeneral<>(50));
        arbol.agregarHijo(new ArbolGeneral<>(12));
        arbol.agregarHijo(new ArbolGeneral<>(501));
        arbol.agregarHijo(new ArbolGeneral<>(123));
        arbol.getHijos().proximo().agregarHijo(new ArbolGeneral<>(12));
        ProductoHojasProfundas p = new ProductoHojasProfundas();
        System.out.println(p.resolver(arbol));
    }
}
