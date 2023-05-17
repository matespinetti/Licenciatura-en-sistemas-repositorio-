package ParcialAYED1;

import tp03.ejercicio1.ArbolBinario;

public class ParcialArboles {
    private ArbolBinario<Integer> arbol;
    public boolean isLeftTree(int num) {
        Elem elem = new Elem();
        boolean encontreN = false;
        if (!arbol.esVacio()){
            encontreN = isLeftTree(arbol, elem, num);
        }

        if (encontreN){
            return elem.getCumple();
        } else{
            return false;
        }
    }

    private boolean isLeftTree(ArbolBinario<Integer> ab, Elem elem, int num){ //El nombre del parametro tenia que ser arbol, tuve un error ya que siempre que escribo arbol en este proceso me refiero al arbol que tomo como parametro, no a la variable de instancia.
        boolean encontreN = false;
        if (ab.getDato() == num){
            encontreN = true;
            if (arbol.tieneHijoIzquierdo() & !arbol.tieneHijoDerecho()){
                elem.setCumple(true);
            } else if (arbol.tieneHijoIzquierdo()){
                contarHijos(ab, elem, num);
            }
        }

        if (!encontreN && arbol.tieneHijoIzquierdo()){
           encontreN = isLeftTree(arbol.getHijoIzquierdo(), elem, num);
        }

        if (!encontreN && arbol.tieneHijoDerecho()){
            encontreN= isLeftTree(arbol.getHijoDerecho(), elem, num);
        }

        return encontreN;
    }


    private int contarHijos(ArbolBinario<Integer> arbol, Elem elem, int n){
        if (arbol.esHoja()){
            return 0;
        } else {
            int cantIzq = 0;
            int cantDer = 0;
            if (arbol.tieneHijoIzquierdo()){
                cantIzq += contarHijos(arbol.getHijoIzquierdo(), elem, n);
            }
            if (arbol.tieneHijoDerecho()){
                cantDer += contarHijos(arbol.getHijoDerecho(), elem, n);
            }

            int total = cantIzq + cantDer;

            if (arbol.getDato() == n){
                if (cantIzq > cantDer){
                    elem.setCumple(true);
                }
            }
            if ((arbol.tieneHijoIzquierdo() && !arbol.tieneHijoDerecho()) ||(!arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho())){
                total++;
            }

            return total;
        }
    }

    private class Elem{
        private boolean cumple = false;

        public boolean getCumple() {
            return cumple;
        }

        public void setCumple(boolean cumple) {
            this.cumple = cumple;
        }
    }
}
