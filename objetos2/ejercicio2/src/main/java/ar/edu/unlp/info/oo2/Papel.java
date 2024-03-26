package ar.edu.unlp.info.oo2;

public class Papel implements Opcion {
    public String getResultado(Opcion opcion) {
        switch (opcion.getClass().getSimpleName()) {
            case "Piedra":
                return "Gana";
            case "Papel":
                return "Empate";
            case "Tijera":
                return "Pierde";
            case "Lagarto":
                return "Pierde";
            case "Spock":
                return "Gana";
        }
        return null;
    }

}
