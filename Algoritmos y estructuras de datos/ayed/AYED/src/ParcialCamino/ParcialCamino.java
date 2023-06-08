package ParcialCamino;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ParcialCamino {

    public ListaGenerica<Integer> caminoLejano (ArbolGeneral<Integer> arbol) {
        int alturaArbol = arbol.altura();
        boolean encontre = false;
        int camino = 0;
        ListaGenerica<Integer> listaCamino = new ListaEnlazadaGenerica<>();
        caminoLejano(arbol, alturaArbol, camino, listaCamino);
        return listaCamino;


    }

    private boolean caminoLejano (ArbolGeneral<Integer> arbol, int alturaArbol, int camino, ListaGenerica<Integer> lista){
        boolean encontro = false;
        if (arbol.esHoja()) {
            if ((alturaArbol == camino)) {
                lista.agregarFinal(arbol.getDato());
                encontro = true;
            }
        }
        else {

            ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
            hijos.comenzar();
            while ((!hijos.fin()) && (!encontro)){
                encontro = caminoLejano(hijos.proximo(), alturaArbol, camino+1, lista);
            }
            if (encontro){
                lista.agregarInicio(arbol.getDato());
            }



        }
        return encontro;
    }
}
