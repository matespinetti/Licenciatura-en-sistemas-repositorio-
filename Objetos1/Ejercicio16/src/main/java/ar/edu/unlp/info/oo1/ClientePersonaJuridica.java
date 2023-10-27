package ar.edu.unlp.info.oo1;

public class ClientePersonaJuridica extends Cliente{
    private int CUIT;
    private String tipo;

    public ClientePersonaJuridica(String nombre, String direccion, Long numeroTelefono, int CUIT, String tipo) {
        super(nombre, direccion, numeroTelefono);
        this.CUIT = CUIT;
        this.tipo = tipo;
    }
}
