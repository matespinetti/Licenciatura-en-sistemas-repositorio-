package ConjuntoParciales.ParcialQueMeTomaron;

import ParcialAYED1.Parcial;
import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>(15);
        arbol.agregarHijoIzquierdo(new ArbolBinario<>(30));



        Parcial p = new Parcial(arbol);
        System.out.println(p.isLeftTree(15));

    }

}
