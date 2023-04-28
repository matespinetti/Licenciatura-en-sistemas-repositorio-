package ParcialCodigo;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Prueba {
    public static void main(String[] args) {
        Camino c = new Camino();
        ArbolGeneral<ElementoArbol> arbol = new ArbolGeneral<ElementoArbol>(new ElementoArbol(1, 'J'));
        arbol.agregarHijo(new ArbolGeneral<ElementoArbol>(new ElementoArbol(3, 'B')));
        arbol.agregarHijo(new ArbolGeneral<ElementoArbol>(new ElementoArbol(2, 'W')));
        arbol.agregarHijo(new ArbolGeneral<ElementoArbol>(new ElementoArbol(5 , 'N')));
        ListaGenerica<Character> lista = c.devolverCamino(arbol);
        lista.comenzar();
        while (!lista.fin()) {
            System.out.println(lista.proximo());
        }

    }

}
