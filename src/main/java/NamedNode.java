public class NamedNode extends Node {
    private String name;

    public String getName() {
        return "\"" + this.name + "\"";
    }

    public NamedNode(String name) {
        super();
        this.name = name;
    }
}
