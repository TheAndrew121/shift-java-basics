package homework24;

class Autobot extends Transformer {
    private static final String eyeColor = "синий";

    public Autobot(String name, String transformationForm) {
        super(name, true, transformationForm); // Автоботы по умолчанию добрые
    }


    @Override
    public String getTeamName() {
        return "Автоботы";
    }

    @Override
    public String getEyeColor() {
        return eyeColor;
    }
}