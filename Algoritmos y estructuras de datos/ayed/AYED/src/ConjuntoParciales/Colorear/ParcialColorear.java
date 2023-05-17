package ConjuntoParciales.Colorear;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ParcialColorear {
    public void colorearArbol (ArbolBinario<String> arbol, Integer maxColor) {
        ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<>();
        ArbolBinario<String> arbol2;
        cola.encolar(arbol);
        cola.encolar(null);
        int nivel = 0;
        int cantNivel = 0;
        while (!cola.esVacia()) {
            arbol2 = cola.desencolar();
            if (arbol2 != null){
                cantNivel++;
                if (cantNivel <= maxColor) {
                    if (nivel % 2 == 0) {
                        arbol2.setDato("negro");
                    } else {
                        arbol2.setDato("rojo");
                    }
                } else {
                    arbol2.setDato("verde");
                }
                System.out.println(arbol2.getDato());
                if (arbol2.tieneHijoIzquierdo()) {
                    cola.encolar(arbol2.getHijoIzquierdo());
                }
                if (arbol2.tieneHijoDerecho()) {
                    cola.encolar(arbol2.getHijoDerecho());
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                nivel ++;
                cantNivel = 0;
            }
        }

    }
}
