package ar.edu.unlp.info.oo2;

public class Piedra implements Opcion{
    @Override
    public String getResultado(Opcion opcion) {
        switch (opcion.getClass().getSimpleName()) {
            case "Piedra":
                return "Empate";
            case "Papel":
                return "Pierde";
            case "Tijera":
                return "Gana";
            case "Lagarto":
                return "Gana";
            case "Spock":
                return "Pierde";
        }
        return null;
    }
}
