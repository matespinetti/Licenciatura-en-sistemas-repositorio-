package ConjuntoParciales.ParcialQueMeTomaron;

import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>(15);
        arbol.agregarHijoDerecho(new ArbolBinario<>(30));
        arbol.agregarHijoIzquierdo(new ArbolBinario<>(45));
        arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(50));


        Parcial p = new Parcial(arbol);
        System.out.println(p.isLeftTree(15));

    }

}
