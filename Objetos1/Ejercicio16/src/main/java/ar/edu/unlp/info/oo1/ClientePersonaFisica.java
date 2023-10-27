package ar.edu.unlp.info.oo1;

public class ClientePersonaFisica extends Cliente {
    private int DNI;

    public ClientePersonaFisica(String nombre, String direccion, Long numeroTelefono, int DNI) {
        super(nombre, direccion, numeroTelefono);
        this.DNI = DNI;
    }
}
