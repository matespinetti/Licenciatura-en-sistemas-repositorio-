package ar.edu.unlp.info.oo2;

public class Tijera implements Opcion{
    public String getResultado(Opcion opcion) {
        switch (opcion.getClass().getSimpleName()) {
            case "Piedra":
                return "Pierde";
            case "Papel":
                return "Gana";
            case "Tijera":
                return "Empate";
            case "Lagarto":
                return "Gana";
            case "Spock":
                return "Pierde";
        }
        return null;
    }
}
