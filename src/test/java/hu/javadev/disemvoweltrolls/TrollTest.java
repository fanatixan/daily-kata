package hu.javadev.disemvoweltrolls;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Disemvowelling trolls")
class TrollTest {

    private Troll troll;

    @BeforeEach
    void setup() {
        troll = new Troll();
    }

    @DisplayName("for null input throws exception")
    @Test
    void givenNull_disemvowel_shouldThrowException() {
        // given
        String comment = null;

        // when
        ThrowableAssert.ThrowingCallable disemvowel = () -> troll.disemvowel(comment);

        // then
        assertThatThrownBy(disemvowel).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("for empty input returns empty")
    @Test
    void givenEmptyString_disemvowel_shouldReturnEmptyString() {
        // given
        String comment = "";

        // when
        String result = troll.disemvowel(comment);

        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("for single character, non-vowel input returns untouched")
    @Test
    void givenSingleNonVowel_disemvowel_shouldReturnTheSame() {
        // given
        String comment = "b";

        // when
        String result = troll.disemvowel(comment);

        // then
        assertThat(result).isEqualTo(comment);
    }

    @DisplayName("for single vowel input returns empty")
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"a", "e", "i", "o", "u", "A"})
    void givenSingleVowel_disemvowel_shouldReturnEmptyString(String comment) {
        // given

        // when
        String result = troll.disemvowel(comment);

        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("for mixed input returns without vowels")
    @Test
    void givenMixedInput_disemvowel_shouldReturnWithoutVowels() {
        // given
        String comment = "Mixed";

        // when
        String result = troll.disemvowel(comment);

        // then
        assertThat(result).isEqualTo("Mxd");
    }

}
