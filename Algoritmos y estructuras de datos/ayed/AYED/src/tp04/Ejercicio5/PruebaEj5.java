package tp04.Ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class PruebaEj5 {
    public static void main(String[] args) {
        ArbolGeneral<AreaEmpresa> arbol = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("Manualidades", 15 ), new ListaEnlazadaGenerica<>());
        arbol.agregarHijo(new ArbolGeneral<>(new AreaEmpresa("vehiculos", 93)));
        arbol.agregarHijo(new ArbolGeneral<>(new AreaEmpresa("comida", 55)));
        arbol.agregarHijo(new ArbolGeneral<>(new AreaEmpresa("bebida", 43)));

        AnalizadorArbol analizador = new AnalizadorArbol();
        System.out.println(analizador.devolverMaximoPromedio(arbol));

    }



}
