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
public class Investigador {
    private String nombreCompleto;
    private int categoria;
    private String especialidad;
    private Subsidio[] subsidios;
    private int cantSubsidios;

    public Investigador(String nombreCompleto, int categoria, String especialidad) {
        this.nombreCompleto = nombreCompleto;
        this.categoria = categoria;
        this.especialidad = especialidad;
        this.subsidios = new Subsidio [5];
   
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Subsidio[] getSubsidios() {
        return subsidios;
    }

    public void setSubsidios(Subsidio[] subsidios) {
        this.subsidios = subsidios;
    }

    public int getCantSubsidios() {
        return cantSubsidios;
    }

    
    public void agregarSubsidio (Subsidio s) {
        if (this.getCantSubsidios() < 5) {
            this.getSubsidios() [this.getCantSubsidios()] = s;
            this.cantSubsidios ++;
        
        }
    }
    
    public double dineroOtorgadoPorInvestigador () {
        double dinero = 0;
        for (int i = 0;i < this.getCantSubsidios(); i++ ) {
            if (this.subsidios[i].isOtorgado())
                dinero += this.subsidios[i].getMonto();
        }
        
        return dinero;
    }
    
    
   public void otorgarSubsidios () {
       for (int i = 0; i < this.cantSubsidios ; i++)
           this.subsidios[i].setOtorgado(true);
   }

    @Override
    public String toString() {
        String mensaje = String.format ("Nombre: %s, Categoria: %d, especialidad: %s, dinero subsidios otorgados: %.2f", this.getNombreCompleto(), this.getCategoria(), this.getEspecialidad(), this.dineroOtorgadoPorInvestigador());
        return mensaje;
    }
    
    
    
    
}