package homework22;

import java.util.Scanner;
import java.util.ArrayList;

public class MultiplicationTable {

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

        printMultiplicationTable(firstNumber, secondNumber, step);
    }

    public static void printMultiplicationTable(int first, int second, int step) {
        // генерация последовательности чисел
        ArrayList<Integer> numbers = generateSequence(first, second, step);

        int maxWidth = findMaxCellWidth(numbers);

        printHeader(numbers, maxWidth);

        // строки таблицы
        for (int i = 0; i < numbers.size(); i++) {
            printRow(numbers, i, maxWidth);
        }
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

    public static void printHeader(ArrayList<Integer> columns, int cellWidth) {
        // первая ячейка пустая
        System.out.printf("%" + cellWidth + "s |", "");

        // заголовки столбцов
        for (int num : columns) {
            System.out.printf(" %" + cellWidth + "d |", num);
        }
        System.out.println();

        printSeparatorLine(columns.size() + 1, cellWidth);
    }

    public static void printRow(ArrayList<Integer> numbers, int rowIndex, int cellWidth) {
        int rowNum = numbers.get(rowIndex);

        System.out.printf("%" + cellWidth + "d |", rowNum);

        // ячейки с произведениями
        for (int colNum : numbers) {
            int product = rowNum * colNum;
            System.out.printf(" %" + cellWidth + "d |", product);
        }
        System.out.println();

        printSeparatorLine(numbers.size() + 1, cellWidth);
    }

    public static void printSeparatorLine(int columnsCount, int cellWidth) {
        int separatorLength = cellWidth + 3;
        String separator = "-".repeat(columnsCount * separatorLength);
        System.out.println(separator);
    }
}