package homework24;

import java.util.HashMap;
import java.util.Map;

public class TransformerDemo {

    public static void main(String[] args) {
        // Создаем HashMap для хранения информации о трансформерах по имени
        Map<String, Transformer> transformers = new HashMap<>();

        // Создаем трансформеров
        transformers.put("Bumblebee", new Autobot("Бамблби", "Chevrolet Camaro"));
        transformers.put("Optimus Prime", new Autobot("Оптимус прайм", "тягач"));
        transformers.put("Starscream", new Decepticon("Скандалист", "истребитель"));
        transformers.put("Soundwave", new Decepticon("Саундвейв", "магнитофон"));
        transformers.put("Megatron", new Decepticon("Мегатрон", "пушка"));

        // объединенный вывод всех возможностей трансформеров
        System.out.println("=== Возможности трансформеров ===");
        transformers.values().forEach(t -> {
            t.run();
            t.fire();
            t.charge();
            t.transform();
            System.out.println();
        });

        // свойства всех трансформеров
        System.out.println("=== Свойства трансформеров ===");
        transformers.values().forEach(Transformer::displayProperties);

        // Изменение формы трансформации
        System.out.println("\n=== Трансформация ===");
        transformers.get("Bumblebee").setTransformationForm("Volkswagen Beetle");
        transformers.get("Starscream").setTransformationForm("бомбардировщик");

        System.out.println("После трансформации:");
        transformers.get("Bumblebee").transform();
        transformers.get("Starscream").transform();

        System.out.println("\n=== Трансформация ===");
        transformers.get("Megatron").setTransformationForm("танк");
        transformers.get("Optimus Prime").setTransformationForm("пожарная машина");

        transformers.get("Megatron").transform();
        transformers.get("Optimus Prime").transform();

        // System.out.println("\n=== Трансформеры поменялись местами ===");
        transformers.get("Bumblebee").setKindness(false);
        transformers.get("Starscream").setKindness(true);
        transformers.get("Megatron").setKindness(true);
        transformers.get("Optimus Prime").setKindness(false);

        //System.out.println("Бамблби добрый?: " + booleanToYesNo(transformers.get("Bumblebee").isKindness()));
        //System.out.println("Is Starscream kind?: " + booleanToYesNo(transformers.get("Starscream").isKindness()));
        //System.out.println("Is Megatron kind?: " + booleanToYesNo(transformers.get("Megatron").isKindness()));

        // Финальные свойства возможно УБРАТЬ???
        System.out.println("\n=== Свойства после трансформации и смены сторон ===");
        transformers.values().forEach(Transformer::displayProperties);
    }

    /*
    private static String booleanToYesNo(boolean value) {
        return value ? "Да" : "Нет";
    }

     */
}