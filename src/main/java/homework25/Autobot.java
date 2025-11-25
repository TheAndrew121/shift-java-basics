package homework25;

class Autobot extends Transformer implements Action {
    private String teamName;
    private final String eyeColor = "синий";
    private boolean kindness;

    public Autobot(String name, String teamName) {
        super(name);
        this.teamName = teamName;
        this.kindness = true;
    }

    // реализация абстрактного метода transform
    public void transform() {
        System.out.println(name + " трансформируется в транспорт");
    }

    // реализация методов интерфейса Action
    public void fire() {
        System.out.println(name + " стреляет");
    }

    public void charge() {
        System.out.println(name + " заряжается");
    }

    // переопределение метода run по умолчанию
    @Override
    public void run() {
        System.out.println(name + " бежит");
    }

    public String getTeamName() {
        return teamName;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isKindness() {
        return kindness;
    }

    public void setKindness(boolean kindness) {
        this.kindness = kindness;
    }
}