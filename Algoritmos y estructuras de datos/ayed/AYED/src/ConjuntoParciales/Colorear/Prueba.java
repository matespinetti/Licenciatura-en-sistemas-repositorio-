package ConjuntoParciales.Colorear;

import ConjuntoParciales.SumaImpares.Parcial;
import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {
        ArbolBinario<String> arbol = new ArbolBinario<>();
        arbol.agregarHijoIzquierdo(new ArbolBinario<>());
        arbol.agregarHijoDerecho(new ArbolBinario<>());
        ParcialColorear parcialColorear = new ParcialColorear();
        parcialColorear.colorearArbol(arbol, 1);
    }
}
