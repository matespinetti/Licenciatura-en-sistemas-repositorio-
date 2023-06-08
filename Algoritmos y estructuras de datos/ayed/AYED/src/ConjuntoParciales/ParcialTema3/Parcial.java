package ConjuntoParciales.ParcialTema3;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {
    private ArbolBinario<Integer> arbol;

    public Parcial(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean isTwoTree(int num) {
        ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
        ArbolBinario<Integer> arbol2 = null;
        boolean encontre = false;
        cola.encolar(arbol);
        while (!encontre && !cola.esVacia()) {
            arbol2 = cola.desencolar();
            if (arbol2.getDato() == num) {
                encontre = true;
            } else {
                if (arbol2.tieneHijoIzquierdo()){
                    cola.encolar(arbol2.getHijoIzquierdo());
                }
                if (arbol2.tieneHijoDerecho()){
                    cola.encolar(arbol2.getHijoDerecho());
                }
            }
        }

        boolean cumple = false;
        if (encontre){
            int cantIzq = -1;
            int cantDer = -1;
            if (arbol2.tieneHijoIzquierdo()) {
                cantIzq = buscar(arbol2.getHijoIzquierdo());
            }

            if (arbol2.tieneHijoDerecho()){
                cantDer = buscar(arbol2.getHijoDerecho());
            }

            if (cantIzq == cantDer) {
                cumple = true;
            }
        }


        return cumple;

    }

    private int buscar(ArbolBinario<Integer> arbol){
        if (arbol.esHoja()){
            return 0;
        } else {
            int cantIzq = 0;
            int cantDer = 0;
            if (arbol.tieneHijoIzquierdo()){
                cantIzq += buscar(arbol.getHijoIzquierdo());
            }

            if (arbol.tieneHijoDerecho()){
                cantDer += buscar(arbol.getHijoDerecho());
            }


            int total = cantIzq + cantDer;

            if (arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho()){
                total++;
            }

            return total;


        }
    }
}
