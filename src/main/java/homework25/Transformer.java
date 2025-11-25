package homework25;

abstract class Transformer {
    protected String name;

    public Transformer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract void transform();
}