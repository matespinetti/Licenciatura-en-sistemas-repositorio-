package ConjuntoParciales.Ejercicio7.Ejercicio8;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class PruebaEj8 {
    public static void main(String[] args) {
        ArbolGeneral<Integer> arbol = new ArbolGeneral<Integer>(15);
        arbol.agregarHijo(new ArbolGeneral<>(45));
        arbol.agregarHijo(new ArbolGeneral<Integer>(53));
        arbol.agregarHijo(new ArbolGeneral<Integer>(98));

        ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
        ArbolGeneral<Integer>hijo1 = hijos.proximo();
        hijo1.agregarHijo(new ArbolGeneral<Integer>(45));
        ArbolGeneral<Integer>hijo2 = hijos.proximo();
        hijo2.agregarHijo(new ArbolGeneral<Integer>(23));
        hijo2.agregarHijo(new ArbolGeneral<Integer>(44));
        ArbolGeneral<Integer>hijo3 = hijos.proximo();
        hijo3.agregarHijo(new ArbolGeneral<Integer>(115));
        Ej8 ej8 = new Ej8(arbol);
        ListaGenerica<Integer> lista =ej8.resolverPorNiveles();
        lista.comenzar();
        while (!lista.fin()){
            System.out.println(lista.proximo());
        }
    }

}
