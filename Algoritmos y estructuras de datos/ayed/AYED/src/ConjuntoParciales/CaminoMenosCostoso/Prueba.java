package ConjuntoParciales.CaminoMenosCostoso;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol43 = new ArbolBinario<>(43);
        arbol43.agregarHijoIzquierdo(new ArbolBinario<>(431));
        arbol43.agregarHijoDerecho(new ArbolBinario<>(2));
        arbol43.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(3));


        CaminoMenosCostoso c = new CaminoMenosCostoso();
        c.setArbol(arbol43);
        ListaGenerica<Integer> lista = c.caminoMenosCostosoAHojaMasLejana();
        lista.comenzar();
        while (!lista.fin()){
            System.out.println(lista.proximo());
        }
    }

}
