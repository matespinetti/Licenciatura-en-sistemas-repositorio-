package ParcilProcesador;


import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProcesadorDeArbol {
    ArbolBinario<Integer> arbol;

    public ProcesadorDeArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ObjetoADevolver procesar(){
        ObjetoADevolver objReturn= new ObjetoADevolver();
        procesar(arbol, objReturn);
        return objReturn;

    }

    private void procesar(ArbolBinario<Integer> arbol,ObjetoADevolver obj){
        if (!arbol.esVacio()){
            int cantHijos = 0;
            if (arbol.tieneHijoIzquierdo()){
                procesar(arbol.getHijoIzquierdo(), obj);
                cantHijos++;
            }

            if (arbol.tieneHijoDerecho()){
                procesar(arbol.getHijoDerecho(), obj);
                cantHijos++;
            }

            if (arbol.getDato() % 2 == 1){
                obj.setCantImpares(obj.getCantImpares()+1);
                if (cantHijos == 1) {

                    ListaGenerica<Integer> lista = obj.getLista();
                    lista.agregarFinal(arbol.getDato());
                    obj.setLista(lista);
                }
            }


        }


    }
}
