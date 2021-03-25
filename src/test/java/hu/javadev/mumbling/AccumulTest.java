package hu.javadev.mumbling;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Mumbling")
class AccumulTest {

    private Accumul accumul;

    @BeforeEach
    void setup() {
        accumul = new Accumul();
    }

    @DisplayName("for null should throw exception")
    @Test
    void givenNull_accum_shouldThrowException() {
        // given
        String input = null;

        // when
        ThrowingCallable accum = () -> accumul.accum(input);

        // then
        assertThatThrownBy(accum).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("for empty string shoule be empty")
    @Test
    void givenEmptyString_accum_shouldReturnEmpty() {
        // given
        var input = "";

        // when
        var result = accumul.accum(input);

        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("for single uppercase letter should be the same")
    @Test
    void givenSingleUppercaseLetter_accum_shouldReturnSame() {
        // given
        var input = "A";

        // when
        var result = accumul.accum(input);

        // then
        assertThat(result).isEqualTo("A");
    }

    @DisplayName("for single lowercase letter should be converted to uppercaes")
    @Test
    void givenSingleLowercaseLetter_accum_shouldConvertItToUppercase() {
        // given
        var input = "b";

        // when
        var result = accumul.accum(input);

        // then
        assertThat(result).isEqualTo("B");
    }

    @DisplayName("for lowercase second letter should be first upper, dash, second upper then lower")
    @Test
    void givenLowercaseSecondLetter_accum_shouldConvertSecondToUpperThenLower() {
        // given
        var input = "ab";

        // when
        var result = accumul.accum(input);

        // then
        assertThat(result).isEqualTo("A-Bb");
    }

    @DisplayName("for uppercase second letter should be first upper, dash, second upper then lower")
    @Test
    void givenUppercaseSecondLetter_accum_shouldConvertSecondToUpperThenLower() {
        // given
        var input = "aB";

        // when
        var result = accumul.accum(input);

        // then
        assertThat(result).isEqualTo("A-Bb");
    }

    @DisplayName("for three letters should be all converted to mumbling")
    @Test
    void givenThreeLetters_accum_shouldConvertAllToMumbling() {
        // given
        var input = "abc";

        // when
        var result = accumul.accum(input);

        // then
        assertThat(result).isEqualTo("A-Bb-Ccc");
    }

}
