package ConjuntoParciales.Parcial2022;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial2022 {
    public ListaGenerica<Integer> resolver (ArbolBinario<Integer> ab, int min){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        objetoReturn obj = new objetoReturn();
        resolver2(ab, min, lista);
        return lista;
    }

    private boolean resolver (ArbolBinario<Integer> ab, int min, ListaGenerica<Integer> lista, objetoReturn obj) {
        boolean seguir = true;
        if (!ab.esVacio()) {
            if (ab.getDato() % 2 == 0){
                min--;
            }
            lista.agregarFinal(ab.getDato());

            if (ab.esHoja()) {
                if (min <= 0) {
                    seguir = false;
                    obj.setLista(lista);
                }
            }
            else {
                ListaGenerica<Integer> listaIzq = lista.clonar();
                ListaGenerica<Integer> listaDer = lista.clonar();
                boolean seguirIzq = true;
                boolean seguirDer = true;
                if (ab.tieneHijoIzquierdo()){
                    seguirIzq = resolver(ab.getHijoIzquierdo(), min, listaIzq, obj);
                }

                if (ab.tieneHijoDerecho() && seguirIzq){
                    seguirDer = resolver (ab.getHijoDerecho(), min, listaDer, obj);
                }


                return (seguirIzq && seguirDer);
            }
        }
        return seguir;
    }

    public boolean resolver2(ArbolBinario<Integer> ab, int min, ListaGenerica<Integer> lista){
        boolean encontre = false;
        if (ab.getDato() % 2 == 0) {
            min --;
        }
        lista.agregarFinal(ab.getDato());

        if (ab.esHoja()){
            if (min <= 0) {
                encontre = true;
            }
            else {
                lista.eliminarEn(lista.tamanio());
            }
        } else {
            if (ab.tieneHijoIzquierdo()){
                encontre = resolver2(ab.getHijoIzquierdo(), min, lista);
            }

            if (ab.tieneHijoDerecho() & !encontre){
                encontre = resolver2(ab.getHijoDerecho(), min, lista);
            }

            if (!encontre){
                lista.eliminarEn(lista.tamanio());
            }


        }

        return encontre;

    }

    class objetoReturn {
        private boolean seguir;
        private ListaGenerica<Integer> lista;

        public boolean isSeguir() {
            return seguir;
        }

        public void setSeguir(boolean seguir) {
            this.seguir = seguir;
        }

        public ListaGenerica<Integer> getLista() {
            return lista;
        }

        public void setLista(ListaGenerica<Integer> lista) {
            this.lista = lista;
        }
    }
}
