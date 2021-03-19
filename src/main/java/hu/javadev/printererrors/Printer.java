package hu.javadev.printererrors;

public class Printer {

    private static final char GREATEST_VALID_CHARACTER = 'm';

    public String printerError(String s) {
        long errorCount = s.chars()
                .filter(c -> !isValid(c))
                .count();

        return String.format("%d/%d", errorCount, s.length());
    }

    private boolean isValid(int c) {
        return c <= GREATEST_VALID_CHARACTER;
    }

}
