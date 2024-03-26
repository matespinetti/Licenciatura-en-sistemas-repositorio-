package ar.edu.unlp.info.oo1;

public abstract class Usuario {
    private String nombre;
    private double saldo;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.saldo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void descontarSaldo(double cant){
        this.saldo = this.saldo - cant;
    }

    public void incrementarSaldo(double cant ){
        this.saldo = this.saldo + cant;
    }

    public abstract void bonificar();

}
