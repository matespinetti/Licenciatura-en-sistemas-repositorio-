package ConjuntoParciales.Ejercicio1;

import ConjuntoParciales.ParcialSeleccion.Elemento;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ej1 {

    public ListaGenerica<Character> caminoValor(ArbolGeneral<ElementoEj1> arbol){
        ListaGenerica<Character> lista = new ListaEnlazadaGenerica<Character>();
        caminoValor(arbol, lista);
        return lista;
    }
    private  void caminoValor (ArbolGeneral<ElementoEj1> arbol, ListaGenerica<Character> lista){
        if (arbol.esHoja()) {
            lista.agregarFinal(arbol.getDato().getCar());
        } else {
            ListaGenerica<ArbolGeneral<ElementoEj1>> hijos = arbol.getHijos();
            hijos.comenzar();
            if (arbol.getDato().getValor() <= hijos.tamanio()) {
                lista.agregarFinal(arbol.getDato().getCar());
                caminoValor(hijos.elemento(arbol.getDato().getValor()), lista);
            }

        }
    }


}
