package hu.javadev.highestandlowest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Maximum and minimum of")
class RangeUtilTest {

    private RangeUtil rangeUtil;

    @BeforeEach
    void setup() {
        rangeUtil = new RangeUtil();
    }

    @DisplayName("a single number should be the number")
    @Test
    void givenSingleNumber_highAndLow_shouldReturnItTwoTimes() {
        // given
        String input = "5";

        // when
        String result = rangeUtil.highAndLow(input);

        // then
        assertThat(result).isEqualTo("5 5");
    }

    @DisplayName("a larger and smaller number should be those in the same order")
    @Test
    void givenLargerAndSmallerNumber_highAndLow_shouldReturnThemInTheSameOrder() {
        // given
        String input = "5 1";

        // when
        String result = rangeUtil.highAndLow(input);

        // then
        assertThat(result).isEqualTo("5 1");
    }

    @DisplayName("a smaller and larger number should be those in reversed order")
    @Test
    void givenSmallerAndLargerNumber_highAndLow_shouldReturnThemInReversedOrder() {
        // given
        String input = "1 5";

        // when
        String result = rangeUtil.highAndLow(input);

        // then
        assertThat(result).isEqualTo("5 1");
    }

    @DisplayName("three numbers should be max followed by min")
    @Test
    void givenThreeNumbers_highAndLow_shouldReturnMaxFollowedByMin() {
        // given
        String input = "1 5 4";

        // when
        String result = rangeUtil.highAndLow(input);

        // then
        assertThat(result).isEqualTo("5 1");
    }

}
