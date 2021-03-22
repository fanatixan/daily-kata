package hu.javadev.findthemissingletter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Finding the missing letter in a sequence")
class LetterSequenceTest {

    private LetterSequence letterSequence;

    @BeforeEach
    void setup() {
        letterSequence = new LetterSequence();
    }

    @DisplayName("of two elements with missing second")
    @Test
    void givenTwoLowercaseLettersWithMissingSecond_findMissingLetter_shouldReturnMissingElement() {
        // given
        char[] letters = {'a', 'c'};

        // when
        char missingLetter = letterSequence.findMissingLetter(letters);

        // then
        assertThat(missingLetter).isEqualTo('b');
    }

    @DisplayName("of two uppercase elements with missing second")
    @Test
    void givenTwoUppercaseLettersWithMissingSecond_findMissingLetter_shouldReturnMissingElement() {
        // given
        char[] letters = {'A', 'C'};

        // when
        char missingLetter = letterSequence.findMissingLetter(letters);

        // then
        assertThat(missingLetter).isEqualTo('B');
    }

    @DisplayName("of three elements with missing third")
    @Test
    void givenThreeLowercaseLettersWithMissingThird_findMissingLetter_shouldReturnMissingElement() {
        // given
        char[] letters = {'a', 'b', 'd'};

        // when
        char missingLetter = letterSequence.findMissingLetter(letters);

        // then
        assertThat(missingLetter).isEqualTo('c');
    }

    @DisplayName("of three elements with missing second")
    @Test
    void givenThreeLowercaseLettersWithMissingSecond_findMissingLetter_shouldReturnMissingElement() {
        // given
        char[] letters = {'a', 'c', 'd'};

        // when
        char missingLetter = letterSequence.findMissingLetter(letters);

        // then
        assertThat(missingLetter).isEqualTo('b');
    }

    @DisplayName("of four elements with missing third")
    @Test
    void givenFourLowercaseLettersWithMissingThird_findMissingLetter_shouldReturnMissingElement() {
        // given
        char[] letters = {'a', 'b', 'd', 'e'};

        // when
        char missingLetter = letterSequence.findMissingLetter(letters);

        // then
        assertThat(missingLetter).isEqualTo('c');
    }

}
