package Parcialito;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {

        ArbolBinario<Integer> arbol = new ArbolBinario<>(40);
        arbol.agregarHijoIzquierdo(new ArbolBinario<>(5));
        arbol.agregarHijoDerecho(new ArbolBinario<>(20));
        arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(15));

        ParcialEj1 parc = new ParcialEj1(arbol);
        ObjetoDevolver obj = parc.procesar();
        System.out.println(obj.getCantPares());
        ListaGenerica<ArbolBinario<Integer>> lista = obj.getLista();
        lista.comenzar();
        while (!lista.fin()){
            System.out.println(lista.proximo().getDato());
        }

    }
}
