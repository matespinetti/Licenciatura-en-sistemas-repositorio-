package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Empleado> empleados;

    public Sistema(){
        this.empleados = new ArrayList<>();
    }
    public void darAltaEmpleado(String nombre, String apellido, int cuil, LocalDate fecha){

    }

    public Empleado buscarEmpleado(int cuit){

    }

    public void darBajaEmpleado(Empleado e){

    }

    public void cargarContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valor, int horas){

    }

    public void cargarContratoDePlanta(LocalDate fechaInicio, double sueldoMensual, double montoConyugue, double montoHijos){

    }
    public List<Empleado> obtenerEmpleadosContratosVencidos(){

    }

    public List<Recibo> generarRecibosDeSueldo(){

    }

}
