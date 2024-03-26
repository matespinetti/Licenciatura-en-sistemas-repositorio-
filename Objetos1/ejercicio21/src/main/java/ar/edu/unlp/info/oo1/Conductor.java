package ar.edu.unlp.info.oo1;

public class Conductor extends Usuario{

    private Vehiculo vehiculo;

    public Conductor(String nombre, Vehiculo vehiculo) {
        super(nombre);
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void bonificar(){
        this.incrementarSaldo(this.vehiculo.getValor() * 0.1);

    }
}
