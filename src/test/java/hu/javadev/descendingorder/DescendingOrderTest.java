package hu.javadev.descendingorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Descending order")
class DescendingOrderTest {

    private DescendingOrder descendingOrder;

    @BeforeEach
    void setup() {
        descendingOrder = new DescendingOrder();
    }

    @DisplayName("of single digit is the same")
    @Test
    void givenSingleDigit_sort_shouldReturnItUnchanged() {
        // given
        var input = 1;

        // when
        var result = descendingOrder.sort(input);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("of two descending digits is the same")
    @Test
    void givenTwoDescendingDigits_sort_shouldReturnItUnchanged() {
        // given
        var input = 31;

        // when
        var result = descendingOrder.sort(input);

        // then
        assertThat(result).isEqualTo(31);
    }

    @DisplayName("of two descending digits is reversed")
    @Test
    void givenTwoAscendingDigits_sort_shouldReturnItReversed() {
        // given
        var input = 13;

        // when
        var result = descendingOrder.sort(input);

        // then
        assertThat(result).isEqualTo(31);
    }

    @DisplayName("of three digits in random order is sorted descending")
    @Test
    void givenThreeDigitsInRandomOrder_sort_shouldReturnThemSorted() {
        // given
        var input = 316;

        // when
        var result = descendingOrder.sort(input);

        // then
        assertThat(result).isEqualTo(631);
    }

}
