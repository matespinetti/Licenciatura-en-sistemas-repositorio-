package ConjuntoParciales.CaminoAHojaMasLejana;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Prueba {
    public static void main(String[] args) {
        CaminoAHojaMasLejana camino = new CaminoAHojaMasLejana();
        ArbolGeneral<Integer> arbol = new ArbolGeneral<Integer>(1);
        arbol.agregarHijo(new ArbolGeneral<>(2));
        arbol.agregarHijo(new ArbolGeneral<Integer>(3));
        arbol.agregarHijo(new ArbolGeneral<Integer>(4));

        ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
        ArbolGeneral<Integer>hijo1 = hijos.proximo();
        hijo1.agregarHijo(new ArbolGeneral<Integer>(5));
        ArbolGeneral<Integer>hijo2 = hijos.proximo();
        hijo2.agregarHijo(new ArbolGeneral<Integer>(6));
        hijo2.agregarHijo(new ArbolGeneral<Integer>(7));
        ArbolGeneral<Integer>hijo3 = hijos.proximo();
        hijo3.agregarHijo(new ArbolGeneral<Integer>(8));
        ListaGenerica<Integer> lista = camino.hojaMasLejana(arbol);
        lista.comenzar();
        while (!lista.fin()) {
            System.out.println(lista.proximo());
        }

    }
}
