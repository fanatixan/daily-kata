package hu.javadev.twotoone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Two to one longest")
class TwoToOneTest {

    private TwoToOne twoToOne;

    @BeforeEach
    void setup() {
        twoToOne = new TwoToOne();
    }

    @DisplayName("of two empty strings is empty string")
    @Test
    void givenTwoEmptyStrings_longest_shouldReturnEmpty() {
        // given
        var s1 = "";
        var s2 = "";

        // when
        var result = twoToOne.longest(s1, s2);

        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("of a single-letter and an empty string is the first")
    @Test
    void givenSingleLetterAndEmptyString_longest_shouldReturnFirst() {
        // given
        var s1 = "a";
        var s2 = "";

        // when
        var result = twoToOne.longest(s1, s2);

        // then
        assertThat(result).isEqualTo("a");
    }

    @DisplayName("of an empty and single-letter string is the first")
    @Test
    void givenEmptyAndSingleLetterString_longest_shouldReturnSecond() {
        // given
        var s1 = "";
        var s2 = "b";

        // when
        var result = twoToOne.longest(s1, s2);

        // then
        assertThat(result).isEqualTo("b");
    }

    @DisplayName("of a repeated letter and an empty string is the letter once")
    @Test
    void givenRepeatedLetterAndEmptyString_longest_shouldReturnLetterOnce() {
        // given
        var s1 = "aa";
        var s2 = "";

        // when
        var result = twoToOne.longest(s1, s2);

        // then
        assertThat(result).isEqualTo("a");
    }

    @DisplayName("of the same letter twice is the letter once")
    @Test
    void givenSameSingleLetterStringTwice_longest_shouldReturnLetterOnce() {
        // given
        var s1 = "a";
        var s2 = "a";

        // when
        var result = twoToOne.longest(s1, s2);

        // then
        assertThat(result).isEqualTo("a");
    }

    @DisplayName("of multiple letters twice in the same order is them once")
    @Test
    void givenMultipleLettersTwiceInTheSameOrder_longest_shouldReturnThemOnce() {
        // given
        var s1 = "ab";
        var s2 = "ab";

        // when
        var result = twoToOne.longest(s1, s2);

        // then
        assertThat(result).isEqualTo("ab");
    }

    @DisplayName("of different letters is them combined")
    @Test
    void givenDifferentLetters_longest_shouldReturnThemCombined() {
        // given
        var s1 = "ab";
        var s2 = "cd";

        // when
        var result = twoToOne.longest(s1, s2);

        // then
        assertThat(result).isEqualTo("abcd");
    }

    @DisplayName("of multiple letters twice in different order is them once")
    @Test
    void givenMultipleLettersTwiceInDifferentOrder_longest_shouldReturnThemOnce() {
        // given
        var s1 = "ab";
        var s2 = "ba";

        // when
        var result = twoToOne.longest(s1, s2);

        // then
        assertThat(result).isEqualTo("ab");
    }

    @DisplayName("of different letters in random order is them combined and sorted")
    @Test
    void givenDifferentLettersInRandomOrder_longest_shouldReturnThemCombinedAndSorted() {
        // given
        var s1 = "dc";
        var s2 = "ba";

        // when
        var result = twoToOne.longest(s1, s2);

        // then
        assertThat(result).isEqualTo("abcd");
    }

}
