package ru.rvmedvedev;

import java.util.LinkedHashSet;
import java.util.Set;

public class NameBuilder {

    static Set<String> buildColumnNames(Set<Integer> numbers) {
        Set<String> columnNames = new LinkedHashSet<>();
        for (Integer number : numbers) {
            columnNames.add(buildColumnName(number));
        }
        return columnNames;
    }

    private static String buildColumnName(int number) {
        String name = null;
        if (number <= 26) {
            name = getLetter(number);
        } else {
            for (int i = 1; i <= 26; i++) {
                if ((number - i) % 26 == 0) {
                    name = buildColumnName((number - i) / 26) + getLetter(i);
                }
            }
        }
        return name;
    }

    private static String getLetter(int number) {
        return String.valueOf((char) (number + 64));
    }
}
