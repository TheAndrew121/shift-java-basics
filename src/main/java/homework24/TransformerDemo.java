package homework24;

public class TransformerDemo {
    static void main(String[] args) {
        // создаём одного автобота и одного десептикона
        Autobot bumblebee = new Autobot("Бамблби", "Автоботы");
        Decepticon starscream = new Decepticon("Скандалист", "Десептиконы");

        // действия автоботов
        System.out.println("=== Возможности автобота ===");
        bumblebee.run();
        bumblebee.fire();
        bumblebee.charge();
        bumblebee.transform();

        // свойства автоботов
        System.out.println("\n=== Свойства автобота ===");
        System.out.println("Имя: " + bumblebee.getName());
        System.out.println("Команда: " + bumblebee.getTeamName());
        System.out.println("Цвет глаз: " + bumblebee.getEyeColor());
        System.out.println("Добрый?: " + bumblebee.isKindness());

        // действия десептиконов
        System.out.println("\n=== Возможности десептикона ===");
        starscream.run();
        starscream.fire();
        starscream.charge();
        starscream.transform();

        // свойства десептиконов
        System.out.println("\n=== Свойства десептикона ===");
        System.out.println("Имя: " + starscream.getName());
        System.out.println("Команда: " + starscream.getTeamName());
        System.out.println("Цвет глаз: " + starscream.getEyeColor());
        System.out.println("Добрый?: " + starscream.isKindness());




        System.out.println("\n=== Трансформеры поменялись местами ===");
        bumblebee.setKindness(false); // автобот стал злым
        starscream.setKindness(true); // десептикон стал добрым

        System.out.println("Добрый?: " + bumblebee.isKindness());
        System.out.println("Добрый?: " + starscream.isKindness());


    }
}
