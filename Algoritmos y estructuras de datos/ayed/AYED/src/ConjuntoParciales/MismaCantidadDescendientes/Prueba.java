package ConjuntoParciales.MismaCantidadDescendientes;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol1 = new ArbolBinario<>(1);
        arbol1.agregarHijoIzquierdo(new ArbolBinario<>(16));
        arbol1.agregarHijoDerecho(new ArbolBinario<>(6));
        ArbolBinario<Integer> arbol2 = new ArbolBinario<>(2);
        arbol2.agregarHijoIzquierdo(arbol1);
        arbol2.agregarHijoDerecho(new ArbolBinario<>(5));
        arbol2.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(8));
        arbol2.getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(22));
        MismaCantidadDescendientes misma = new MismaCantidadDescendientes();
        ListaGenerica<Integer> lista = misma.resolver(arbol2);
        lista.comenzar();
        while (!lista.fin()) {
            System.out.println(lista.proximo());
        }
    }
}
