package ConjuntoParciales.Ejercicio6;

import tp03.ejercicio1.ArbolBinario;

public class Ej6 {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>(35);
        arbol.agregarHijoIzquierdo(new ArbolBinario<>(9));
        arbol.agregarHijoDerecho(new ArbolBinario<>(14));
        arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(90));
        NivelArbol nivel = new NivelArbol(arbol);
        ArbolBinario<Integer> devolucion = nivel.minEnNivelAB(0);
        if (devolucion != null){
            System.out.println(devolucion.getDato());
        } else {
            System.out.println("NULL");
        }

    }

}
