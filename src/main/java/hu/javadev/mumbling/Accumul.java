package hu.javadev.mumbling;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Accumul {

    public String accum(String s) {
        Objects.requireNonNull(s);

        return IntStream.range(0, s.length())
                .mapToObj(index -> toMumbling(s.charAt(index), index + 1))
                .collect(Collectors.joining("-"));
    }

    private String toMumbling(char c, int length) {
        return Character.toUpperCase(c)
                + String.valueOf(Character.toLowerCase(c)).repeat(length - 1);
    }

}
