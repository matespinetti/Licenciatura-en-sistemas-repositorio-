package ConjuntoParciales.Ejercicio1;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class PruebaEj1 {
    public static void main(String[] args) {
        ArbolGeneral<ElementoEj1> arbolE= new ArbolGeneral<ElementoEj1>(new ElementoEj1('E', 2));
        arbolE.agregarHijo(new ArbolGeneral<ElementoEj1>(new ElementoEj1('A', 7)));
        arbolE.agregarHijo(new ArbolGeneral<ElementoEj1>(new ElementoEj1('B', 9)));
        arbolE.agregarHijo(new ArbolGeneral<ElementoEj1>(new ElementoEj1('C', 6)));
        ArbolGeneral<ElementoEj1> arbolF= new ArbolGeneral<ElementoEj1>(new ElementoEj1('F', 2));
        arbolF.agregarHijo(new ArbolGeneral<ElementoEj1>(new ElementoEj1('D', 10)));
        ArbolGeneral<ElementoEj1> arbolJ= new ArbolGeneral<ElementoEj1>(new ElementoEj1('J', 5));
        arbolJ.agregarHijo(new ArbolGeneral<ElementoEj1>(new ElementoEj1('H', 5)));
        arbolJ.agregarHijo(new ArbolGeneral<ElementoEj1>(new ElementoEj1('I', 10)));
        ArbolGeneral<ElementoEj1> arbolG= new ArbolGeneral<ElementoEj1>(new ElementoEj1('G', 2));
        arbolG.agregarHijo(arbolE);
        arbolG.agregarHijo(arbolF);
        arbolG.agregarHijo(arbolJ);

        ej1 e = new ej1();
        ListaGenerica<Character> lista = e.caminoValor(arbolG);
        lista.comenzar();
        while (!lista.fin()){
            System.out.println(lista.proximo());
        }






    }


}
