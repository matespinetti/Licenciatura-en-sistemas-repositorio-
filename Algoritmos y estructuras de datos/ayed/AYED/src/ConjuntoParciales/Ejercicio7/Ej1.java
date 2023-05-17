package ConjuntoParciales.Ejercicio7;

import tp03.ejercicio1.ArbolBinario;

public class Ej1 {
    public Integer sumaImparesPosOrdenMayorA(ArbolBinario<Integer> ab, int limite){
        int suma = 0;
        if (!ab.esVacio()) {
            if (ab.tieneHijoIzquierdo()) {
                suma += sumaImparesPosOrdenMayorA(ab.getHijoIzquierdo(), limite);
            }
            if (ab.tieneHijoDerecho()) {
                suma += sumaImparesPosOrdenMayorA(ab.getHijoDerecho(), limite);
            }

            if (ab.getDato() > limite) {
                suma += ab.getDato();
            }
        }

        return suma;
    }



}
