package ar.edu.unlp.info.oo2;


import java.time.LocalDate;

public abstract class FileDecorator implements FileComponent {
    protected FileComponent component;
    public FileDecorator(FileComponent component) {
        this.component = component;
    }
    public abstract String prettyPrint();
    public String getNombre() {
        return this.component.getNombre();
    }
    public String getPermisos() {
        return this.component.getPermisos();
    }
    public double getTamano() {
        return this.component.getTamano();
    }
    public String getExtension() {
        return this.component.getExtension();
    }
    public LocalDate getFechaCreacion() {
        return this.component.getFechaCreacion();
    }
    public LocalDate getFechaModificacion() {
        return this.component.getFechaModificacion();
    }
}
