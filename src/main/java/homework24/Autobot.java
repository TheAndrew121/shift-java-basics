package homework24;

class Autobot extends Transformer {
    private String teamName;
    private final String eyeColor = "синий";
    private boolean kindness;

    public Autobot(String name, String teamName) {
        super(name);
        this.teamName = teamName;
        this.kindness = true; // по умолчанию true
    }

    public void transform() {
        System.out.println(name + " трансформируется в транспорт");
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

    // сеттер для kindness
    public void setKindness(boolean kindness) {
        this.kindness = kindness;
    }
}