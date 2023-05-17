package ConjuntoParciales.Gematria;

import tp04.ejercicio1.ArbolGeneral;

public class Prueba {
    public static void main(String[] args) {
        ArbolGeneral<Integer> arbol = new ArbolGeneral<>(0);
        arbol.agregarHijo(new ArbolGeneral<>(50));
        arbol.agregarHijo(new ArbolGeneral<>(12));
        arbol.agregarHijo(new ArbolGeneral<>(10));
        arbol.agregarHijo(new ArbolGeneral<>(50));
        ProcesadorGematria p = new ProcesadorGematria();
        System.out.println(p.contar(arbol, 0));
    }

}
