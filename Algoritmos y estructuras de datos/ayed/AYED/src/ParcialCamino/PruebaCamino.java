package ParcialCamino;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class PruebaCamino {
    public static void main(String[] args) {
        ParcialCamino p = new ParcialCamino();
        ArbolGeneral<Integer> arbol = new ArbolGeneral<>(15);
        arbol.agregarHijo(new ArbolGeneral<>(22));
        arbol.agregarHijo(new ArbolGeneral<>(13));
        arbol.agregarHijo(new ArbolGeneral<>(14));
        ListaGenerica<ArbolGeneral<Integer>> listaHijos = arbol.getHijos();
        listaHijos.comenzar();
        listaHijos.proximo().agregarHijo(new ArbolGeneral<>(500));
        listaHijos.proximo().agregarHijo(new ArbolGeneral<>(99));

        ListaGenerica<Integer> listaCamino= p.caminoLejano(arbol);
        listaCamino.comenzar();
        while (!listaCamino.fin()){
            System.out.println(listaCamino.proximo());
        }
    }


}
