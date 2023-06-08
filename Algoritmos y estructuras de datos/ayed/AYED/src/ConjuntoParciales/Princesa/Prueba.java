package ConjuntoParciales.Princesa;

import ConjuntoParciales.Ejercicio2.Personaje;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp04.ejercicio1.ArbolGeneral;

public class Prueba {
    public static void main(String[] args) {
        ArbolGeneral<Personaje> dragonNegro = new ArbolGeneral<Personaje>(new Personaje("dragon", "negro"));
        dragonNegro.agregarHijo(new ArbolGeneral<>(new Personaje("princesa", "Cenicienta")));
        dragonNegro.agregarHijo(new ArbolGeneral<>(new Personaje("dragon", "rojo")));
        dragonNegro.agregarHijo(new ArbolGeneral<>(new Personaje("Animal", "pluto")));

        ArbolGeneral<Personaje> animalCid = new ArbolGeneral<Personaje>(new Personaje("Animal", "cid"));
        animalCid.agregarHijo(new ArbolGeneral<>(new Personaje("princesa", "la bella")));
        animalCid.agregarHijo(new ArbolGeneral<>(new Personaje("Animal", "Tweety")));

        ArbolGeneral<Personaje> animalCoyote = new ArbolGeneral<Personaje>(new Personaje("Animal", "Coyote"));
        animalCoyote.agregarHijo(new ArbolGeneral<>(new Personaje("Animal", "scooby")));
        animalCoyote.agregarHijo(dragonNegro);
        animalCoyote.agregarHijo(animalCid);

        ParcialPrincesa p = new ParcialPrincesa();
        ListaGenerica<Personaje> lista = p.caminoAccesible(animalCoyote);
        lista.comenzar();
        while (!lista.fin()) {
            Personaje pers = lista.proximo();
            System.out.println(pers.getTipo() + pers.getNombre() );
        }


    }
}

