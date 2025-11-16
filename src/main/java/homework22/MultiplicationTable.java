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
        // генерация последовательностей чисел
        ArrayList<Integer> rowNumbers = generateSequence(first, second, step);
        ArrayList<Integer> colNumbers = generateSequence(first, second, step);

        // проверка, что последовательности не пустые
        if (rowNumbers.isEmpty() || colNumbers.isEmpty()) {
            System.out.println("Ошибка: невозможно сгенерировать последовательность с заданными параметрами.");
            return;
        }

        int maxWidth = findMaxCellWidth(rowNumbers, colNumbers);

        printHeader(colNumbers, maxWidth);

        // строки таблицы
        for (int i = 0; i < rowNumbers.size(); i++) {
            printRow(rowNumbers, colNumbers, i, maxWidth);
        }
    }

    public static ArrayList<Integer> generateSequence(int start, int end, int step) {
        ArrayList<Integer> sequence = new ArrayList<>();

        if (step > 0) {
            // для положительного шага: start должен быть меньше end
            if (start <= end) {
                for (int i = start; i <= end; i += step) {
                    sequence.add(i);
                }
            }
        } else {
            // для отрицательного шага: start должен быть больше end
            if (start >= end) {
                for (int i = start; i >= end; i += step) {
                    sequence.add(i);
                }
            }
        }

        return sequence;
    }

    public static int findMaxCellWidth(ArrayList<Integer> rows, ArrayList<Integer> cols) {
        int maxWidth = 0;

        // максимальная ширина среди всех возможных произведений
        for (int row : rows) {
            for (int col : cols) {
                int product = row * col;
                int width = getCellWidth(product);
                if (width > maxWidth) {
                    maxWidth = width;
                }
            }
        }

        //  проверка ширины самих чисел в заголовках
        for (int num : rows) {
            int width = getCellWidth(num);
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        for (int num : cols) {
            int width = getCellWidth(num);
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }

    public static int getCellWidth(int number) {
        String data = String.valueOf(number);
        return data.length();
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

    public static void printRow(ArrayList<Integer> rows, ArrayList<Integer> columns, int rowIndex, int cellWidth) {
        int rowNum = rows.get(rowIndex);

        System.out.printf("%" + cellWidth + "d |", rowNum);

        // ячейки с произведениями
        for (int colNum : columns) {
            int product = rowNum * colNum;
            System.out.printf(" %" + cellWidth + "d |", product);
        }
        System.out.println();

        printSeparatorLine(columns.size() + 1, cellWidth);
    }

    public static void printSeparatorLine(int columnsCount, int cellWidth) {
        int separatorLength = cellWidth + 3;

        for (int i = 0; i < columnsCount * separatorLength; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}