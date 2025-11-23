package homework24;

class Decepticon extends Transformer {
    private String teamName;
    private final String eyeColor = "красный";
    private boolean kindness;

    public Decepticon(String name, String teamName) {
        super(name);
        this.teamName = teamName;
        this.kindness = false;
    }

    public void transform() {
        System.out.println(name + " трансформируется в наземный и воздушный транспорт, в оружие и технику");
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
