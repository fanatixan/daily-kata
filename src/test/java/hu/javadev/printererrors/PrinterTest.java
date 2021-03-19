package hu.javadev.printererrors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Print error")
class PrinterTest {

    private Printer printer;

    @BeforeEach
    void setup() {
        printer = new Printer();
    }

    @DisplayName("for a single valid character should be '0/1'")
    @Test
    void givenSingleValidCharacter_printerError_shouldReturnZeroFromOne() {
        // given
        String input = "a";

        // when
        String result = printer.printerError(input);

        // then
        assertThat(result).isEqualTo("0/1");
    }

    @DisplayName("for a single smallest invalid character should be '1/1'")
    @Test
    void givenSingleSmallestInvalidCharacter_printerError_shouldReturnOneFromOne() {
        // given
        String input = "n";

        // when
        String result = printer.printerError(input);

        // then
        assertThat(result).isEqualTo("1/1");
    }

    @DisplayName("for a single greatest valid character should be '0/1'")
    @Test
    void givenSingleGreatestValidCharacter_printerError_shouldReturnZeroFromOne() {
        // given
        String input = "m";

        // when
        String result = printer.printerError(input);

        // then
        assertThat(result).isEqualTo("0/1");
    }

    @DisplayName("for a two valid characters should be '0/2'")
    @Test
    void givenTwoValidCharacters_printerError_shouldReturnZeroFromTwo() {
        // given
        String input = "ab";

        // when
        String result = printer.printerError(input);

        // then
        assertThat(result).isEqualTo("0/2");
    }

    @DisplayName("for a valid and an invalid character should be '1/2'")
    @Test
    void givenValidAndInvalidCharacter_printerError_shouldReturnOneFromTwo() {
        // given
        String input = "az";

        // when
        String result = printer.printerError(input);

        // then
        assertThat(result).isEqualTo("1/2");
    }

    @DisplayName("for an invalid and a valid character should be '1/2'")
    @Test
    void givenInvalidAndValidCharacter_printerError_shouldReturnOneFromTwo() {
        // given
        String input = "za";

        // when
        String result = printer.printerError(input);

        // then
        assertThat(result).isEqualTo("1/2");
    }

}
