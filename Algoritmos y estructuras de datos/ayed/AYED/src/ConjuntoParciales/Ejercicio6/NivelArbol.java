package ConjuntoParciales.Ejercicio6;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class NivelArbol {

    ArbolBinario<Integer> arbol;

    public NivelArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ArbolBinario<Integer> minEnNivelAB(int n){
        ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
        ArbolBinario<Integer> arbol2 = arbol;
        ArbolBinario<Integer> arbolDevolver = null;
        cola.encolar(arbol2);
        cola.encolar(null);
        int minNivel = Integer.MAX_VALUE;
        int nivel = 0;
        while (!cola.esVacia() && nivel <=n){
            arbol2 = cola.desencolar();
            if (arbol2 != null) {
                if (arbol2.esHoja()){
                    if (nivel == n){
                        if (arbol.getDato() < minNivel) {
                            minNivel = arbol.getDato();
                            arbolDevolver= arbol2;
                        }
                    }
                } else {
                    if (arbol2.tieneHijoIzquierdo()) {
                        cola.encolar(arbol2.getHijoIzquierdo());
                    }
                    if (arbol2.tieneHijoDerecho()) {
                        cola.encolar(arbol2.getHijoDerecho());
                    }
                }
            } else if (!cola.esVacia()){
                cola.encolar(null);
                nivel++;
            }
        }

        return arbolDevolver;
    }
}
