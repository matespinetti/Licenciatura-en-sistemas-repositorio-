package ConjuntoParciales.SumaImpares;

import tp03.ejercicio1.ArbolBinario;

public class Parcial {
    public Integer sumaImparesPosOrdenMayorA(ArbolBinario<Integer> ab, int limite) {
        int suma = 0;
        if (ab.esVacio()){
            return 0;
        }
        else {
            if (ab.esHoja()){
                if ((ab.getDato() > limite) && (ab.getDato() % 2 == 1)){
                    suma += ab.getDato();
                }

            } else {
                if (ab.tieneHijoIzquierdo()) {
                    suma += sumaImparesPosOrdenMayorA(ab.getHijoIzquierdo(), limite);
                }

                if (ab.tieneHijoDerecho()) {
                    suma += sumaImparesPosOrdenMayorA(ab.getHijoDerecho(), limite);
                }

                if ((ab.getDato() > limite) && (ab.getDato() % 2 == 1)){
                    suma += ab.getDato();
                }


             }
        }

        return suma;
    }
}
