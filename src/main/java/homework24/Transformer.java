package homework24;

class Transformer {
    protected String name;

    public Transformer(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " бежит");
    }

    public void fire() {
        System.out.println(name + " стреляет");
    }

    public void charge() {
        System.out.println(name + " заряжается");
    }

    public String getName() {
        return name;
    }
}