package homework25;

import java.util.ArrayList;
import java.util.List;

public class TransformerDemo {
    public static void main(String[] args) {
        // создаём автобота и десептиконов
        Autobot bumblebee = new Autobot("Бамблби", "Автоботы");
        // с указанием, во что конкретно трансформируется десептикон
        Decepticon starscream = new Decepticon("Скандалист", "Десептиконы", "истребитель");
        Decepticon megatron = new Decepticon("Мегатрон", "Десептиконы", "пушка");
        Decepticon soundwave = new Decepticon("Саундвейв", "Десептиконы", "магнитофон");

        List<Transformer> transformers = new ArrayList<>();
        transformers.add(bumblebee);
        transformers.add(starscream);
        transformers.add(megatron);
        transformers.add(soundwave);

        // демонстрация действий для каждого трансформера
        for (Transformer transformer : transformers) {
            System.out.println("\n=== Действия трансформера " + transformer.getName() + " ===");

            transformer.run();
            transformer.fire();
            transformer.charge();
            transformer.transform();
            System.out.println();
            // свойства
            System.out.println("--- Свойства ---");
            transformer.showProperties();
        }

        System.out.println("\n=== Трансформеры поменялись местами ===");
        bumblebee.setKindness(false); // автобот стал злым
        starscream.setKindness(true); // десептикон стал добрым

        System.out.println("Бамблби добрый?: " + bumblebee.getKindnessText());
        System.out.println("Скандалист добрый?: " + starscream.getKindnessText());
    }
}