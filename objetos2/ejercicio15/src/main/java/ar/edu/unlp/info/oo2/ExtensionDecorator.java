package ar.edu.unlp.info.oo2;

public class ExtensionDecorator extends FileDecorator{
    public ExtensionDecorator(FileComponent component) {
        super(component);
    }

    @Override
    public String prettyPrint() {

        return this.component.prettyPrint()  + component.getExtension() + "-";
    }
}
