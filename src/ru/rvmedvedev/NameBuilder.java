package ru.rvmedvedev;

import java.util.LinkedHashSet;
import java.util.Set;

public class NameBuilder {

    static String getLetter(int number) {
        return String.valueOf((char) (number + 64));
    }


    static Set<String> buldColumnNames(Set<Integer> numbers) {
        Set<String> columnNames = new LinkedHashSet<>();
        for (Integer number : numbers) {
            columnNames.add(buldColumnName(number));
        }
        return columnNames;
    }

    static String buldColumnName(int number) {
        String name = null;
        if (number <= 26)
            name = getLetter(number);
        else {
            for (int i = 1; i <= 26; i++) {
                if ((number - i) % 26 == 0) {
                    name = buldColumnName((number - i) / 26) + getLetter(i);
                }
            }
        }
        return name;
    }
}
