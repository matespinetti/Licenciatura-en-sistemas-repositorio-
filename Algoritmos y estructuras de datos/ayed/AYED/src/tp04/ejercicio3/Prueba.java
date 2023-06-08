package tp04.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;


public class Prueba {
    public static void main(String[] args) {
        RecorridosAG recorridos = new RecorridosAG();
        ArbolGeneral<Integer> a = new ArbolGeneral<>(5, new ListaEnlazadaGenerica<ArbolGeneral<Integer>>());
        a.agregarHijo(new ArbolGeneral<>(15));
        a.agregarHijo(new ArbolGeneral<>(23));
        a.agregarHijo(new ArbolGeneral<>(51));
        a.agregarHijo(new ArbolGeneral<>(123));
        a.getHijos().proximo().agregarHijo(new ArbolGeneral<>(144));

        System.out.println(a.esAncestro(23, 144));
         ListaGenerica<Integer> lista = recorridos.numerosImparesMayoresQuePorNiveles(a, 3);
         lista.comenzar();
         while (!lista.fin()) {
             System.out.println(lista.proximo());

         }


    }

}
