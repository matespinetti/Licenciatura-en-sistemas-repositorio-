package ConjuntoParciales.OtroParcial;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>(15);
        arbol.agregarHijoIzquierdo(new ArbolBinario<>(30));
        arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(40));
        arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(69));
        arbol.agregarHijoDerecho(new ArbolBinario<>(50));
        arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(999));
        arbol.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(1000));
        Parcial p = new Parcial();
        ListaGenerica<Integer> lista = (p.resolver(arbol));
        lista.comenzar();
        while (!lista.fin()){
            System.out.println(lista.proximo());
        }
    }
}
