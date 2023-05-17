package ConjuntoParciales.Ejercicio7;

import tp03.ejercicio1.ArbolBinario;

public class PruebaEj1 {

    public static void main(String[] args) {
        Ej1 ej = new Ej1();
        ArbolBinario<Integer> arbol = new ArbolBinario<>(35);
        arbol.agregarHijoIzquierdo(new ArbolBinario<>(45));
        arbol.agregarHijoDerecho(new ArbolBinario<>(14));

        System.out.println(ej.sumaImparesPosOrdenMayorA(arbol, 30));
    }

}
