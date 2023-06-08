package ConjuntoParciales.MayorElemento;

import tp04.ejercicio1.ArbolGeneral;

public class Prueba {
    public static void main(String[] args) {
        ArbolGeneral<Integer> arbol = new ArbolGeneral<>(500);
        arbol.agregarHijo(new ArbolGeneral<>(50));
        arbol.agregarHijo(new ArbolGeneral<>(12));
        arbol.agregarHijo(new ArbolGeneral<>(501));
        arbol.agregarHijo(new ArbolGeneral<>(123));
        BuscadorDeArbol b = new BuscadorDeArbol();
        b.setArbol(arbol);
        System.out.println(b.buscarMayorEnPosOrden());
    }


}
