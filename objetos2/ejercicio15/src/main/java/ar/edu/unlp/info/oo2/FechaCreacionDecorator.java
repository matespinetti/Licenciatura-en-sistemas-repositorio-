package ar.edu.unlp.info.oo2;

public class FechaCreacionDecorator extends FileDecorator{
    public FechaCreacionDecorator(FileComponent component) {
        super(component);
    }
    @Override
    public String prettyPrint() {
        return this.component.prettyPrint()  + component.getFechaCreacion().toString() + "-";
    }
}
