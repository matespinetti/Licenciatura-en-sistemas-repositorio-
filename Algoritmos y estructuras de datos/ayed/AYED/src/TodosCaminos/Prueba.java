package TodosCaminos;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Prueba {
    public static void main(String[] args) {
        ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(5);
        a.agregarHijo(new ArbolGeneral<>(15));
        a.agregarHijo(new ArbolGeneral<Integer>(23));
        a.agregarHijo(new ArbolGeneral<Integer>(51));
        a.agregarHijo(new ArbolGeneral<>(123));
        a.getHijos().proximo().agregarHijo(new ArbolGeneral<>(54));
        Parcial p = new Parcial();
        ListaGenerica<ListaGenerica<Integer>> lista = p.todosCaminos(a);
        for (int i = 1; i <=lista.tamanio(); i++){
            for (int j= 1; j<=lista.elemento(i).tamanio(); j++) {
                System.out.print(lista.elemento(i).elemento(j) + " ");
            }
            System.out.println(" ");

        }
    }
}
