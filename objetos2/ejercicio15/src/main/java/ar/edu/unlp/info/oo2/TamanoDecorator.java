package ar.edu.unlp.info.oo2;

public class TamanoDecorator extends FileDecorator{
    public TamanoDecorator(FileComponent component) {
        super(component);
    }
    @Override
    public String prettyPrint() {
        return this.component.prettyPrint()  + component.getTamano() + "-";
    }
}
