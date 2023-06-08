package ConjuntoParciales.Ejercicio10;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class PruebaEj10 {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>(35);
        arbol.agregarHijoIzquierdo(new ArbolBinario<>(45));
        arbol.agregarHijoDerecho(new ArbolBinario<>(14));
        arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(34));
        arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(94));
        Parcial p = new Parcial();
        ListaGenerica<Integer> lista = p.resolver(arbol);
        lista.comenzar();
        while (!lista.fin()){
            System.out.println(lista.proximo());
        }
    }

}
