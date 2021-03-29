package hu.javadev.descendingorder;

import java.util.Comparator;

public class DescendingOrder {

    public int sort(final int number) {
        return String.valueOf(number)
                .chars()
                .map(this::characterToDigit)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .reduce(0, (acc, digit) -> acc * 10 + digit);
    }

    private int characterToDigit(int character) {
        return character - '0';
    }

}
