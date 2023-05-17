package ConjuntoParciales.ParcialQueMeTomaron;

import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
    ArbolBinario<Integer> arbol;

    public Parcial(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean isLeftTree (int num){
        Elem elem = new Elem();
        boolean encontre = false;
        if (!arbol.esVacio()) {
            encontre = isLeftTree(arbol, elem, num);
        }

        if (!encontre){
            return false;
        }
        else {
            return elem.isCumple();
        }
    }

    private boolean isLeftTree (ArbolBinario<Integer> arbol, Elem elem, int num) {
        boolean encontre = false;
        if (arbol.getDato() == num) {
            encontre = true;
            int cantIzq = -1;
            int cantDer = -1;
            if (arbol.tieneHijoIzquierdo()){
                cantIzq= buscar(arbol.getHijoIzquierdo(), elem, num);

            }
            if (arbol.tieneHijoDerecho()){
                cantDer = buscar(arbol.getHijoDerecho(), elem, num);
            }

            if (cantIzq > cantDer){
                elem.setCumple(true);
                }
            }


        if (!encontre && arbol.tieneHijoIzquierdo()){
            encontre = isLeftTree(arbol.getHijoIzquierdo(), elem, num);
        }
        if (!encontre && arbol.tieneHijoDerecho()){
            encontre = isLeftTree(arbol.getHijoDerecho(), elem, num);
        }

        return encontre;
    }



    private int buscar(ArbolBinario<Integer> arbol, Elem elem, int num) {

            int cantIzq = 0;
            int cantDer = 0;
            if (arbol.tieneHijoIzquierdo()){
                cantIzq = buscar(arbol.getHijoIzquierdo(), elem, num);
            }
            if (arbol.tieneHijoDerecho()){
                cantDer = buscar(arbol.getHijoDerecho(), elem, num);
            }

            int total = cantIzq + cantDer;


            if ((arbol.tieneHijoIzquierdo() & !arbol.tieneHijoDerecho()) || (!arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho())){
                total++;
            }


            return total;

    }


    private class Elem {
        private boolean cumple = false;

        public boolean isCumple() {
            return cumple;
        }

        public void setCumple(boolean cumple) {
            this.cumple = cumple;
        }
    }

}
