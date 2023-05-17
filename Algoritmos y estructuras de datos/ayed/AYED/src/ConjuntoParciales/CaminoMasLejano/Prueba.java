package ConjuntoParciales.CaminoMasLejano;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Prueba {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>(35);
        arbol.agregarHijoIzquierdo(new ArbolBinario<>(9));
        arbol.agregarHijoDerecho(new ArbolBinario<>(14));
        arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(90));
        arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(53));
        TodosLosCaminosAHojasMasLejana todos = new TodosLosCaminosAHojasMasLejana();
        todos.setArbol(arbol);
        ListaGenerica<ListaGenerica<Integer>> lista = todos.todosLosCaminosAHojasMasLejana();
        lista.comenzar();
        for (int i = 1; i <= lista.tamanio();i++){
            lista.elemento(i).comenzar();
            for (int j= 1; j<= lista.elemento(i).tamanio(); j++) {
                System.out.print(lista.elemento(i).elemento(j) );
            }
            System.out.println(" ");
        }
    }
}
