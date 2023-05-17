package ConjuntoParciales.Ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class PruebaEj5 {
    public static void main(String[] args) {
        ArbolGeneral<Character> arbolE = new ArbolGeneral<Character>('E');
        ArbolGeneral<Character> arbolF = new ArbolGeneral<Character>('F');
        arbolF.agregarHijo(new ArbolGeneral<>('H'));
        arbolF.agregarHijo(new ArbolGeneral<>('I'));
        ArbolGeneral<Character> arbolG = new ArbolGeneral<Character>('G');
        ArbolGeneral<Character> arbolB = new ArbolGeneral<Character>('B');
        arbolB.agregarHijo(arbolE);
        ArbolGeneral<Character> arbolC = new ArbolGeneral<Character>('C');
        arbolC.agregarHijo(arbolF);
        arbolC.agregarHijo(arbolG);
        ArbolGeneral<Character> arbolD = new ArbolGeneral<Character>('D');
        ArbolGeneral<Character> arbolA = new ArbolGeneral<Character>('A');
        arbolA.agregarHijo(arbolB);
        arbolA.agregarHijo(arbolC);
        arbolA.agregarHijo(arbolD);



        Ej5 ej5 = new Ej5();
        ListaGenerica<String> lista =ej5.caminosPares(arbolA);
        lista.comenzar();
        while (!lista.fin()){
            System.out.println(lista.proximo());
        }
    }

}

