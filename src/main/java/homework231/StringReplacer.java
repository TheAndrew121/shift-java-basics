package homework231;

import java.util.Scanner;

public class StringReplacer {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        String inputString = scanner.nextLine();

        char searchSymbol = 0;
        boolean validSymbol = false;

        while (!validSymbol) {
            System.out.println("Введите символ для поиска и замены:");
            String symbolInput = scanner.nextLine();

            if (symbolInput.length() != 1) {
                System.out.println("Нужно ввести ровно один символ");
                continue;
            }

            searchSymbol = symbolInput.charAt(0);
            if (searchSymbol == ' ') {
                System.out.println("Нельзя указывать пробел в качестве символа для поиска");
                continue;
            }

            validSymbol = true;
        }

        String afterReplacement = inputString.replace(searchSymbol, ' ');

        String resultString = normalizeString(afterReplacement);

        System.out.println("\n--- Результат ---");
        // вывод исходной и результирующей строки как одного объекта
        System.out.println(inputString + "\n" + resultString);

        if (inputString.equals(resultString)) {
            System.out.println("\nСтрока не изменилась после преобразований.");
        } else {
            System.out.println("\nСтрока была изменена.");
        }

        scanner.close();
    }

    private static String normalizeString(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        // убираем пробелы, заменяем множественные пробелы на одиночные
        return str.trim().replaceAll("\\s+", " ");
    }
}