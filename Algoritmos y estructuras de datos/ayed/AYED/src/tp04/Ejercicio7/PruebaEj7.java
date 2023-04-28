package tp04.Ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp04.Ejercicio7.RedDeAguaPotable;
import tp04.ejercicio1.ArbolGeneral;

public class PruebaEj7 {

    public static void main(String[] args) {
        ArbolGeneral <Double> arbol = new ArbolGeneral<Double>(5.0);
        arbol.agregarHijo(new ArbolGeneral<>(3.5));
        arbol.agregarHijo(new ArbolGeneral<>(15.9));
        arbol.agregarHijo(new ArbolGeneral<>(99.4));
        ListaGenerica<ArbolGeneral<Double>> hijos = arbol.getHijos();
        hijos.comenzar();
        hijos.elemento(1).agregarHijo(new ArbolGeneral<Double>(14.5));
        hijos.elemento(1).agregarHijo(new ArbolGeneral<Double>(19.5));
        hijos.elemento(1).agregarHijo(new ArbolGeneral<Double>(19.5));
        hijos.elemento(2).agregarHijo(new ArbolGeneral<Double>(19.5));
        hijos.elemento(2).agregarHijo(new ArbolGeneral<Double>(19.5));
        hijos.elemento(2).agregarHijo(new ArbolGeneral<Double>(19.5));
        hijos.elemento(2).agregarHijo(new ArbolGeneral<Double>(19.5));

        RedDeAguaPotable red = new RedDeAguaPotable(arbol);

        System.out.println(red.minimoCaudal(1000));
    }
    }

