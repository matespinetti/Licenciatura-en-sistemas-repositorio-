package ar.edu.unlp.info.oo2;

public class Lagarto implements Opcion{
    public String getResultado(Opcion opcion) {
        switch (opcion.getClass().getSimpleName()) {
            case "Piedra":
                return "Pierde";
            case "Papel":
                return "Gana";
            case "Tijera":
                return "Pierde";
            case "Lagarto":
                return "Empate";
            case "Spock":
                return "Gana";
        }
        return null;
    }
}
