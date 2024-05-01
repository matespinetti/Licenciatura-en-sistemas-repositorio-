package ar.edu.unlp.info.oo2;

public class NombreDecorator extends FileDecorator{
    public NombreDecorator(FileComponent component) {
        super(component);
    }
    @Override
    public String prettyPrint() {
        return this.component.prettyPrint()  + component.getNombre() + "-";
    }
}
