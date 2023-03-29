/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5.ejercicio1;

/**
 *
 * @author Mateo Spinetti
 */
public class Proyecto {
    private String nombre;
    private int codigo;
    private String nombreDirector;
    private Investigador[] investigadores;
    private int cantInvestigadores;

    public Proyecto(String nombre, int codigo, String nombreDirector) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombreDirector = nombreDirector;
        this.investigadores = new Investigador [50];
        this.cantInvestigadores = 0;
    }

    public int getCantInvestigadores() {
        return cantInvestigadores;
    }

    public void setCantInvestigadores(int cantInvestigadores) {
        this.cantInvestigadores = cantInvestigadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public Investigador[] getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(Investigador[] investigadores) {
        this.investigadores = investigadores;
    }
    
    
    
    public void agregarInvestigador (Investigador i) {
        if (this.cantInvestigadores < 50) {
            this.investigadores [this.getCantInvestigadores()] = i;
            this.cantInvestigadores ++;
        }
    }
    
    public double dineroTotalOtorgado () {
        double total = 0;
        for (int i = 0; i < this.getCantInvestigadores(); i++) {
            total += this.investigadores[i].dineroOtorgadoPorInvestigador();
        }
        
        return total;
    }
    
    
    public void otorgarTodos (String nombre) {
        int i = 0;
        boolean encontre = false;
        
        while ((i < this.getCantInvestigadores()) && !(encontre)) {
            if (this.investigadores[i].getNombreCompleto().equals(nombre)) {
                encontre = true;
                this.investigadores[i].otorgarSubsidios();
            }
        i++;
        }
    }

    @Override
    public String toString() {
        String infoInvestigadores = "";
        for (int i = 0; i < this.getCantInvestigadores(); i++)
            infoInvestigadores += this.investigadores [i].toString();
        String mensaje = String.format("Nombre del proyecto: %s, codigo: %d, Nombre director: %s, dinero otorgado: %2f, Investigadores: %s", this.getNombre(), this.getCodigo(), this.getNombreDirector(), this.dineroTotalOtorgado(), infoInvestigadores);
        
        return mensaje;
    }
        
    
    
    
}
