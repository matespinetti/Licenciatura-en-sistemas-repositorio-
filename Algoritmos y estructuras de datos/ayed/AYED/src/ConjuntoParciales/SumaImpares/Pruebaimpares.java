package ConjuntoParciales.SumaImpares;

import tp03.ejercicio1.ArbolBinario;

public class Pruebaimpares {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol43 = new ArbolBinario<>(43);
        arbol43.agregarHijoIzquierdo(new ArbolBinario<>(9));
        arbol43.agregarHijoDerecho(new ArbolBinario<>(10));
        ArbolBinario<Integer> arbol2 = new ArbolBinario<>(43);
        arbol2.agregarHijoIzquierdo(new ArbolBinario<>(1));
        ArbolBinario<Integer> arbol38 = new ArbolBinario<>(38);
        arbol38.agregarHijoIzquierdo(new ArbolBinario<>(87));
        arbol38.agregarHijoDerecho(new ArbolBinario<>(77));
        arbol38.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(16));
        arbol38.getHijoDerecho().getHijoIzquierdo().agregarHijoDerecho(arbol43);
        ArbolBinario<Integer> arbol56 = new ArbolBinario<>(56);
        arbol56.agregarHijoIzquierdo(arbol38);
        arbol56.agregarHijoDerecho(new ArbolBinario<>(31));
        arbol56.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(94));
        arbol56.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(arbol2);
        ArbolBinario<Integer> arbol25 = new ArbolBinario<>(25);
        arbol25.agregarHijoIzquierdo(new ArbolBinario<>(5));
        arbol25.agregarHijoDerecho(new ArbolBinario<>(6));
        ArbolBinario<Integer> arbol7 = new ArbolBinario<>(7);
        arbol7.agregarHijoIzquierdo(arbol56);
        arbol7.agregarHijoDerecho(arbol25);
        Parcial p = new Parcial();
        System.out.println(p.sumaImparesPosOrdenMayorA(arbol7, 15));

    }
}
