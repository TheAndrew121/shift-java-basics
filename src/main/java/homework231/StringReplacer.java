package homework231;

import java.util.Scanner;

public class StringReplacer {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        String inputString = scanner.nextLine();

        String searchSymbolStr;

        while (true) {
            System.out.println("Введите символ для поиска и замены:");
            searchSymbolStr = scanner.nextLine();

            if (searchSymbolStr.length() != 1) {
                System.out.println("Нужно ввести ровно один символ");
                continue;
            }

            if (searchSymbolStr.charAt(0) == ' ') {
                System.out.println("Нельзя указывать пробел в качестве символа для поиска");
                continue;
            }

            break;
        }

        char searchSymbol = searchSymbolStr.charAt(0);
        String outputString = inputString.replace(searchSymbol, ' ');

        outputString = deleteExtraSpaces(outputString);

        System.out.println("\n--- Результат ---");
        System.out.println(inputString + "\n" + outputString);

        if (inputString.equals(outputString)) {
            System.out.println("\nСтрока не изменилась после преобразований.");
        } else {
            System.out.println("\nСтрока была изменена.");
        }

        scanner.close();
    }

    private static String deleteExtraSpaces(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        // теперь только пробелы, а не все пробельные символы
        return str.trim().replaceAll(" +", " ");
    }
}