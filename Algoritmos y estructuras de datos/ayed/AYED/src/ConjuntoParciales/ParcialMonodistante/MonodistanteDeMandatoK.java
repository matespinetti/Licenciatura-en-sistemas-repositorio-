package ConjuntoParciales.ParcialMonodistante;

import tp03.ejercicio1.ArbolBinario;

public class MonodistanteDeMandatoK {
    ArbolBinario<Integer> arbol;

    public boolean esMondodistante(int k) {
        esM es = new esM();
        boolean res = esMonodistante(arbol, k);
        return res;
    }

    public ArbolBinario<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    private boolean esMonodistante(ArbolBinario<Integer> arbol, int k){
        boolean esMono = true;
        if (arbol.esHoja()) {
            if (k- arbol.getDato() != 0){
                esMono = false;
            }
        } else {
            if (k- arbol.getDato() < 0) {
                esMono = false;
            }
            if (esMono) {
                if (arbol.tieneHijoIzquierdo()) {
                    esMono = esMonodistante(arbol.getHijoIzquierdo(), k - arbol.getDato());
                }

                if ((esMono) && (arbol.tieneHijoDerecho())){
                    esMono = esMonodistante(arbol.getHijoDerecho(), k- arbol.getDato());
                }
            }


        }

        return esMono;
    }
    }

