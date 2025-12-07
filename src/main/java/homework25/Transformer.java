package homework25;

abstract class Transformer implements Action {
    protected String name;

    public Transformer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void transform();

    // общий метод отображения свойств
    public void showProperties() {
        System.out.println("Имя: " + name);
    }

}