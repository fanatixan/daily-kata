package hu.javadev.cwars;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CWars {

    public String initials(String name) {
        Objects.requireNonNull(name);

        if (name.isEmpty()) {
            return "";
        }

        String[] words = name.split(" ");
        String shortenedWords = Stream.of(words)
                .limit(words.length - 1)
                .map(this::shorten)
                .collect(Collectors.joining(""));

        return shortenedWords + capitalize(words[words.length - 1]);
    }

    private String shorten(String word) {
        return Character.toUpperCase(word.charAt(0)) + ".";
    }

    private String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

}
