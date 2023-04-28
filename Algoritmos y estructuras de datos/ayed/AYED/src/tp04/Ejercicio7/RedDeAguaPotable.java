package tp04.Ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
    private ArbolGeneral <Double> red;

    public RedDeAguaPotable(ArbolGeneral<Double> red) {
        this.red = red;
    }

    public double minimoCaudal (double caudal){
        return minimoCaudal(this.red, caudal);
    }
    private double minimoCaudal (ArbolGeneral<Double> arbol, double caudal) {
        if (arbol.esHoja()) {
            return caudal;
        }
        else {
            double minimo = Integer.MAX_VALUE;
            ListaGenerica<ArbolGeneral<Double>> hijos = arbol.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                double aux= minimoCaudal(hijos.proximo(), caudal / hijos.tamanio());
                if (aux < minimo) {
                    minimo = aux;
                }
            }
            return minimo;
        }


    }
}
