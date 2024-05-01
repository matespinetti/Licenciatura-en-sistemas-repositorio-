package ar.edu.unlp.info.oo2;

import java.time.LocalDate;

public interface FileComponent {
    public String prettyPrint();
    public String getNombre();
    public String getPermisos();
    public double getTamano();
    public String getExtension();
    public LocalDate getFechaCreacion();
    public LocalDate getFechaModificacion();

}
