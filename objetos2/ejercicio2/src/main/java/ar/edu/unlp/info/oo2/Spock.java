package ar.edu.unlp.info.oo2;

public class Spock implements Opcion{

    public String getResultado(Opcion opcion) {
        switch (opcion.getClass().getSimpleName()) {
            case "Piedra":
                return "Gana";
            case "Papel":
                return "Pierde";
            case "Tijera":
                return "Gana";
            case "Lagarto":
                return "Pierde";
            case "Spock":
                return "Empate";
        }
        return null;
    }
}
