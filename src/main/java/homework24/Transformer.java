package homework24;

abstract class Transformer {
    private String name;
    private boolean kindness;
    private String transformationForm;

    public Transformer(String name, boolean kindness, String transformationForm) {
        this.name = name;
        this.kindness = kindness;
        this.transformationForm = transformationForm;
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

    public abstract String getTeamName();
    public abstract String getEyeColor();

    public boolean isKindness() {
        return kindness;
    }

    public void setKindness(boolean kindness) {
        this.kindness = kindness;
    }

    public String getTransformationForm() {
        return transformationForm;
    }

    public void setTransformationForm(String transformationForm) {
        this.transformationForm = transformationForm;
    }

    public void transform() {
        System.out.println(name + " трансформируется в " + transformationForm);
    }

    // метод для отображения свойств
    public void displayProperties() {
        System.out.println("\n--- " + getName() + " ---");
        System.out.println("Имя: " + getName());
        System.out.println("Команда: " + getTeamName());
        System.out.println("Цвет глаз: " + getEyeColor());
        System.out.println("Добрый?: " + booleanToYesNo(isKindness()));
        System.out.println("Форма трансформации: " + getTransformationForm());
    }

    private String booleanToYesNo(boolean value) {
        return value ? "Да" : "Нет";
    }
}