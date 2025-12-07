package homework25;

class Decepticon extends Transformer implements Action {
    private String teamName;
    private final String eyeColor = "красный";
    private boolean kindness;
    private String transformationType; // тип трансформации

    // конструктор с выбором типа трансформации
    public Decepticon(String name, String teamName, String transformationType) {
        super(name);
        this.teamName = teamName;
        this.kindness = false;
        this.transformationType = transformationType;
    }

    // реализация абстрактного метода transform
    public void transform() {
        System.out.println(name + " трансформируется в " + transformationType);
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

    // переопределение метода showProperties
    @Override
    public void showProperties() {
        super.showProperties();
        System.out.println("Команда: " + teamName);
        System.out.println("Цвет глаз: " + eyeColor);
        System.out.println("Добрый?: " + getKindnessText());
        System.out.println("Тип трансформации: " + transformationType);
    }

    public void setKindness(boolean kindness) {
        this.kindness = kindness;
    }

    public String getKindnessText() {
        return kindness ? "да" : "нет";
    }

}