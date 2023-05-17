package ConjuntoParciales.Ejercicio2;

public class Personaje {
    private String tipo;
    private String nombre;

    public Personaje(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isPrincesa(){
        return this.tipo.equals("princesa");
    }
    public boolean isDragon(){
        return this.tipo.equals("dragon");
    }
}
