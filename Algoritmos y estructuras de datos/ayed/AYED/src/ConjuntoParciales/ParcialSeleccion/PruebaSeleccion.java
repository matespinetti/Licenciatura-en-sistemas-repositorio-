package ConjuntoParciales.ParcialSeleccion;

import tp04.ejercicio1.ArbolGeneral;

public class PruebaSeleccion {
    public static void main(String[] args) {
        ArbolDeSeleccionUtils a = new ArbolDeSeleccionUtils();

        ArbolGeneral<Integer> arbolB = new ArbolGeneral<>(10);
        ArbolGeneral<Integer> arbolC = new ArbolGeneral<>(8);
        ArbolGeneral<Integer> arbolD = new ArbolGeneral<>(9);
        ArbolGeneral<Integer> arbolA = new ArbolGeneral<>(7);
        arbolA.agregarHijo(arbolB);
        arbolA.agregarHijo(arbolC);
        arbolA.agregarHijo(arbolD);
        System.out.println(a.esDeSeleccion(arbolA));

    }


}
