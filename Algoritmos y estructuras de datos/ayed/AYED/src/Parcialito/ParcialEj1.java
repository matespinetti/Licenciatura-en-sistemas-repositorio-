package Parcialito;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ParcialEj1 {
    ArbolBinario<Integer> arbol;

    public ParcialEj1(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }
    public ObjetoDevolver procesar(){
        ListaGenerica<ArbolBinario<Integer>> lista = new ListaEnlazadaGenerica<>();
        int cantPares = procesar(arbol, lista);

        ObjetoDevolver obj = new ObjetoDevolver();
        obj.setCantPares(cantPares);
        obj.setLista(lista);
        return obj;
    }

    private int procesar(ArbolBinario<Integer> arbol, ListaGenerica<ArbolBinario<Integer>> lista){
        int cant = 0;
        if (arbol.esHoja()){
            if (arbol.getDato() % 2 == 0){
                cant++;
            }
        }
        else {

            boolean cumple = false;
            if ((arbol.getDato() % 2) == 0) {
                cant++;
                cumple = true;

            }

            if (arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho() && cumple){
                lista.agregarFinal(arbol);
            }

            if (arbol.tieneHijoIzquierdo()){
                cant += procesar(arbol.getHijoIzquierdo(), lista);
            }

            if (arbol.tieneHijoDerecho()){
                cant += procesar(arbol.getHijoDerecho(), lista);
            }


        }

        return cant;
    }
}
