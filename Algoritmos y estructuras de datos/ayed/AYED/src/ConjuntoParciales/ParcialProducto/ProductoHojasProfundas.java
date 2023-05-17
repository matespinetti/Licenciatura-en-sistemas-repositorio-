package ConjuntoParciales.ParcialProducto;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class ProductoHojasProfundas {
    public int resolver(ArbolGeneral<Integer> a ){
        int altura = 0;
        Elem elem = new Elem();
        if (!a.esVacio()) {
            resolver(a, elem, altura);
        }

        return elem.getMultiplicacion();
    }


    private void resolver (ArbolGeneral<Integer> a, Elem elem, int altura) {
        if (a.esHoja()) {
            if (altura == elem.getAltura()){
                elem.setMultiplicacion(elem.getMultiplicacion() * a.getDato());
            } else if (altura > elem.getAltura()) {
                elem.setAltura(altura);
                elem.setMultiplicacion(a.getDato());
            }
        } else {
            ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                resolver(hijos.proximo(), elem, altura + 1);
            }
        }
    }



    private class Elem {
        int altura = 0;
        int multiplicacion;

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public int getMultiplicacion() {
            return multiplicacion;
        }

        public void setMultiplicacion(int multiplicacion) {
            this.multiplicacion = multiplicacion;
        }
    }
}
