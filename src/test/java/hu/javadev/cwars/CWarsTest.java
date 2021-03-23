package hu.javadev.cwars;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Initials of")
class CWarsTest {

    private CWars cWars;

    @BeforeEach
    void setup() {
        cWars = new CWars();
    }

    @DisplayName("null should be an exception")
    @Test
    void givenNull_initials_shouldThrowException() {
        // given
        String name = null;

        // when
        ThrowableAssert.ThrowingCallable initials = () -> cWars.initials(name);

        // then
        assertThatThrownBy(initials).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("empty string should be empty")
    @Test
    void givenEmptyString_initials_shouldReturnEmpty() {
        // given
        String name = "";

        // when
        String result = cWars.initials(name);

        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("single capitalized word should be the same")
    @Test
    void givenSingleCapitalizedWord_initials_shouldReturnSame() {
        // given
        String name = "Capitalized";

        // when
        String result = cWars.initials(name);

        // then
        assertThat(result).isEqualTo(name);
    }

    @DisplayName("single non-capitalized word should be capitalized")
    @Test
    void givenSingleNonCapitalizedWord_initials_shouldReturnCapitalized() {
        // given
        String name = "lowercase";

        // when
        String result = cWars.initials(name);

        // then
        assertThat(result).isEqualTo("Lowercase");
    }

    @DisplayName("two words should shorten first")
    @Test
    void givenTwoWords_initials_shouldShortenFirst() {
        // given
        String name = "code wars";

        // when
        String result = cWars.initials(name);

        // then
        assertThat(result).isEqualTo("C.Wars");
    }

    @DisplayName("three words should shorten all but last")
    @Test
    void givenThreeWords_initials_shouldShortenAllButLast() {
        // given
        String name = "code wars kata";

        // when
        String result = cWars.initials(name);

        // then
        assertThat(result).isEqualTo("C.W.Kata");
    }

}
