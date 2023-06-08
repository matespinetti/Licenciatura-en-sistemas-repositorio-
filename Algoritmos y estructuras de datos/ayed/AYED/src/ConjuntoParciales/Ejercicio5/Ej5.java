package ConjuntoParciales.Ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ej5 {
    public ListaGenerica<String> caminosPares(ArbolGeneral<Character> arbol) {
        ListaGenerica <String> lista = new ListaEnlazadaGenerica<String>();
        caminosPares(arbol, lista, 1, "");
        return lista;
    }

    private void caminosPares (ArbolGeneral<Character> arbol, ListaGenerica<String> lista, int longitud, String string){


        if (!arbol.esVacio()) {
            string += arbol.getDato();
            if (arbol.esHoja()) {
                if (longitud % 2 == 0) {
                    lista.agregarFinal(string);
                }
            } else {
                ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    caminosPares(hijos.proximo(), lista, longitud + 1, string);
                }


            }
        }
    }
}
