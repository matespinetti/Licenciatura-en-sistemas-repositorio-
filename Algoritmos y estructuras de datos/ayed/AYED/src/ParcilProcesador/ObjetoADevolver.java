package ParcilProcesador;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ObjetoADevolver {
    ListaGenerica<Integer> lista;
    int cantImpares;

    public ObjetoADevolver() {
        lista = new ListaEnlazadaGenerica<Integer>();
        cantImpares = 0;

    }

    public ListaGenerica<Integer> getLista() {
        return lista;
    }

    public void setLista(ListaGenerica<Integer> lista) {
        this.lista = lista;
    }

    public int getCantImpares() {
        return cantImpares;
    }

    public void setCantImpares(int cantImpares) {
        this.cantImpares = cantImpares;
    }
}
