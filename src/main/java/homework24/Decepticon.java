package homework24;

class Decepticon extends Transformer {
    private static final String eyeColor = "красный";

    public Decepticon(String name, String transformationForm) {
        super(name, false, transformationForm); // Десептиконы по умолчанию злые
    }

    public Decepticon(String name, String transformationForm, boolean kindness) {
        super(name, kindness, transformationForm);
    }

    @Override
    public String getTeamName() {
        return "Десептиконы";
    }

    @Override
    public String getEyeColor() {
        return eyeColor;
    }
}