package homework25;

import java.util.ArrayList;
import java.util.List;

public class TransformerDemo {
    static void main(String[] args) {
        // создаём одного автобота и одного десептикона
        Autobot bumblebee = new Autobot("Бамблби", "Автоботы");
        Decepticon starscream = new Decepticon("Скандалист", "Десептиконы");

        List<Transformer> transformers = new ArrayList<>();
        transformers.add(bumblebee);
        transformers.add(starscream);

        // демонстрация действий для каждого трансформера
        for (Transformer transformer : transformers) {
            System.out.println("\n=== Действия трансформера: " + transformer.getName() + " ===");

            // приводим к интерфейсу Action для вызова методов
            Action action = (Action) transformer;
            action.run();
            action.fire();
            action.charge();
            transformer.transform();

            // демонстрация свойств
            System.out.println("--- Свойства ---");
            System.out.println("Имя: " + transformer.getName());

            if (transformer instanceof Autobot autobot) {
                System.out.println("Команда: " + autobot.getTeamName());
                System.out.println("Цвет глаз: " + autobot.getEyeColor());
                System.out.println("Добрый?: " + autobot.isKindness());
            } else if (transformer instanceof Decepticon decepticon) {
                System.out.println("Команда: " + decepticon.getTeamName());
                System.out.println("Цвет глаз: " + decepticon.getEyeColor());
                System.out.println("Добрый?: " + decepticon.isKindness());
            }
        }

        System.out.println("\n=== Трансформеры поменялись местами ===");
        bumblebee.setKindness(false); // автобот стал злым
        starscream.setKindness(true); // десептикон стал добрым

        System.out.println("Бамблби добрый?: " + bumblebee.isKindness());
        System.out.println("Скандалист добрый?: " + starscream.isKindness());
    }
}