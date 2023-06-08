package ConjuntoParciales.Ejercicio3;

import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class PruebaEj3 {
    public static void main(String[] args) {
       ArbolGeneral<Character> arbol = new ArbolGeneral<Character>('A');
       arbol.agregarHijo(new ArbolGeneral<Character>('B'));
       arbol.agregarHijo(new ArbolGeneral<>('C'));
       arbol.agregarHijo(new ArbolGeneral<>('D'));

       Ej3 e = new Ej3();

       ArbolGeneral<Character> res = e.creciente(arbol);
       if (res == null){
           System.out.println("null");
       } else {
           System.out.println(res.getDato());
       }
    }
}
