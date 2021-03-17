package hu.javadev.disemvoweltrolls;

import java.util.Set;
import java.util.stream.Collectors;

public class Troll {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public String disemvowel(String comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Argument 'comment' cannot be null.");
        }

        return comment.replaceAll("(?i)[aeiou]", "");
    }

}
