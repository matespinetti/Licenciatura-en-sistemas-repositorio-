package ParcilProcesador;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class PruebaProcesadorDeArbol {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(15);
        arbol.agregarHijoIzquierdo(new ArbolBinario<Integer>(22));
        arbol.agregarHijoDerecho(new ArbolBinario<Integer>(55));
        arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(83));
        arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(92));
        ProcesadorDeArbol p = new ProcesadorDeArbol(arbol);
        ObjetoADevolver obj = p.procesar();
        System.out.println("Cant elementos Impares : " + obj.getCantImpares());
        System.out.println("Valores que cumplen condicion: ");
        ListaGenerica<Integer> lista = obj.getLista();
        lista.comenzar();
        while (!lista.fin()){
            System.out.println(lista.proximo());
        }
    }
}
