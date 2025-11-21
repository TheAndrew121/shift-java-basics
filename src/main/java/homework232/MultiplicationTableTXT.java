package homework232;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class MultiplicationTableTXT {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Только целые числа");
            scanner.next();
            System.out.print("Введите первое число: ");
        }
        int firstNumber = scanner.nextInt();

        System.out.print("Введите второе число: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Только целые числа");
            scanner.next();
            System.out.print("Введите второе число: ");
        }
        int secondNumber = scanner.nextInt();

        if (firstNumber == secondNumber) {
            System.out.println("Ошибка: первое и второе число не могут быть равны.");
            scanner.close();
            return;
        }

        System.out.print("Введите шаг: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Только целые числа");
            scanner.next();
            System.out.print("Введите шаг: ");
        }
        int step = scanner.nextInt();

        scanner.close();

        if (step == 0) {
            System.out.println("Шаг не может быть равен 0");
            return;
        }

        // проверка направления шага
        if (firstNumber < secondNumber && step < 0) {
            System.out.println("Ошибка: при первом числе меньше второго шаг должен быть положительным.");
            return;
        }

        if (firstNumber > secondNumber && step > 0) {
            System.out.println("Ошибка: при первом числе больше второго шаг должен быть отрицательным.");
            return;
        }

        writeMultiplicationTableToFile(firstNumber, secondNumber, step, "multiplication_table.txt");
    }

    public static ArrayList<Integer> generateSequence(int start, int end, int step) {
        ArrayList<Integer> sequence = new ArrayList<>();

        // генерация последовательности с шагом
        if (step > 0) {
            for (int i = start; i <= end; i += step) {
                sequence.add(i);
            }
        } else {
            for (int i = start; i >= end; i += step) {
                sequence.add(i);
            }
        }

        // добавление крайнего числа, если оно не попадает в диапазон последовательности
        if (!sequence.isEmpty()) {
            int lastNumber = sequence.getLast();
            if (lastNumber != end) {
                sequence.add(end);
            }
        }

        return sequence;
    }

    public static int findMaxCellWidth(ArrayList<Integer> numbers) {
        int maxWidth;

        // максимальная ширина среди всех возможных произведений
        int maxProduct = numbers.getFirst() * numbers.getFirst();
        int minProduct = numbers.getFirst() * numbers.getFirst();

        // находим максимальное и минимальное произведение
        for (int i = 0; i < numbers.size(); i++) {
            for (Integer number : numbers) {
                int product = numbers.get(i) * number;
                if (product > maxProduct) maxProduct = product;
                if (product < minProduct) minProduct = product;
            }
        }

        // максимальная ширина по самому длинному числу
        String maxProductStr = String.valueOf(maxProduct);
        String minProductStr = String.valueOf(minProduct);
        maxWidth = Math.max(maxProductStr.length(), minProductStr.length());

        return maxWidth;
    }

    public static void writeHeader(FileWriter writer, ArrayList<Integer> columns, int cellWidth) throws IOException {
        // первая ячейка пустая
        writer.write(String.format("%" + cellWidth + "s |", ""));

        // заголовки столбцов
        for (int num : columns) {
            writer.write(String.format(" %" + cellWidth + "d |", num));
        }
        writer.write("\n");

        writeSeparatorLine(writer, columns.size() + 1, cellWidth);
    }

    public static void writeRow(FileWriter writer, ArrayList<Integer> numbers, int rowIndex, int cellWidth) throws IOException {
        int rowNum = numbers.get(rowIndex);

        writer.write(String.format("%" + cellWidth + "d |", rowNum));

        // ячейки с произведениями
        for (int colNum : numbers) {
            int product = rowNum * colNum;
            writer.write(String.format(" %" + cellWidth + "d |", product));
        }
        writer.write("\n");

        writeSeparatorLine(writer, numbers.size() + 1, cellWidth);
    }

    public static void writeSeparatorLine(FileWriter writer, int columnsCount, int cellWidth) throws IOException {
        int separatorLength = cellWidth + 3;
        String separator = "-".repeat(columnsCount * separatorLength);
        writer.write(separator + "\n");
    }

    public static void writeMultiplicationTableToFile(int first, int second, int step, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            // генерация последовательности чисел
            ArrayList<Integer> numbers = generateSequence(first, second, step);

            int maxWidth = findMaxCellWidth(numbers);

            writeHeader(writer, numbers, maxWidth);

            // строки таблицы
            for (int i = 0; i < numbers.size(); i++) {
                writeRow(writer, numbers, i, maxWidth);
            }

            System.out.println("Таблица умножения записана в файл: " + filename);

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

}