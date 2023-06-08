package ConjuntoParciales.Princesa;

import ConjuntoParciales.Ejercicio2.Personaje;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class ParcialPrincesa {
    public ListaGenerica<Personaje> caminoAccesible (ArbolGeneral<Personaje> arbol) {
        ListaGenerica<Personaje> lista = new ListaEnlazadaGenerica<>();
        if (!arbol.esVacio()) {
            caminoAccesible(arbol, lista);
        }
        return lista;
    }

    private boolean caminoAccesible (ArbolGeneral<Personaje> arbol, ListaGenerica<Personaje> lista) {
        boolean encontre = false;
        if (!arbol.getDato().isDragon()) {
            lista.agregarFinal(arbol.getDato());
            if (arbol.getDato().isPrincesa()) {
                return true;
            }

            ListaGenerica<ArbolGeneral<Personaje>> hijos = arbol.getHijos();
            hijos.comenzar();
            while ((!hijos.fin()) && (!encontre)) {
                encontre = caminoAccesible(hijos.proximo(), lista);
            }

            if (!encontre) {
                lista.eliminarEn(lista.tamanio());
            }
        }

        return encontre;
    }
}
