package ru.rvmedvedev;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static ru.rvmedvedev.NameBuilder.buildColumnNames;

public class Main {

    public static void main(String[] args) {
        String keyPress;
        Set<Integer> numbers;
        Set<String> columnNames;

        do {
            numbers = new LinkedHashSet<>();
            Scanner input = new Scanner(System.in);

            System.out.println(
                    "Введите числа для тестирования в столбик." +
                            "\n" +
                            "Считывание чисел остановится при вводе других символов."
            );
            while (input.hasNext("\\d+")) {
                numbers.add(input.nextInt());
            }

            columnNames = buildColumnNames(numbers);
            for (String colName : columnNames) {
                System.out.println(colName);
            }

            System.out.println("Для выхода из программы введите 'exit'.");
            keyPress = input.next();

            if (keyPress.equals("exit")) {
                System.exit(0);
            }
        } while (!keyPress.equals("exit"));
    }
}
