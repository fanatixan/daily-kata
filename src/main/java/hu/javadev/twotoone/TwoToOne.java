package hu.javadev.twotoone;

import java.util.stream.Collectors;

public class TwoToOne {

    public String longest(String s1, String s2) {
        return (s1 + s2).chars()
                .distinct()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining(""));
    }

}
