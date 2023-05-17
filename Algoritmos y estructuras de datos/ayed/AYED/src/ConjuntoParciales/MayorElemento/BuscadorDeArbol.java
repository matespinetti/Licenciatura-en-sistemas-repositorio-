package ConjuntoParciales.MayorElemento;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class BuscadorDeArbol {
    ArbolGeneral<Integer> arbol;


    public Integer buscarMayorEnPosOrden(){
        return buscarMayorEnPosOrden(arbol);
    }

    private Integer buscarMayorEnPosOrden(ArbolGeneral<Integer> arbol) {
        if (arbol.esHoja()) {
            return arbol.getDato();
        }
        else {
            int dato = arbol.getDato();
            ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                dato = Math.max(dato, buscarMayorEnPosOrden(hijos.proximo()));
            }

            return dato;
        }
    }

    public ArbolGeneral<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(ArbolGeneral<Integer> arbol) {
        this.arbol = arbol;
    }
}

