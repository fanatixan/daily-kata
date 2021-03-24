package hu.javadev.arithmeticfunction;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Arithmetic function")
class ArithmeticFunctionTest {

    private ArithmeticFunction arithmeticFunction;

    @BeforeEach
    void setup() {
        arithmeticFunction = new ArithmeticFunction();
    }

    @DisplayName("operator")
    @Nested
    class OperatorValidation {

        @DisplayName("is not null")
        @Test
        void givenNullAsOperator_arithmetic_shouldThrowNpe() {
            // given
            int a = 0;
            int b = 0;
            String operator = null;

            // when
            ThrowableAssert.ThrowingCallable arithmetic = () -> arithmeticFunction.arithmetic(a, b, operator);

            // then
            assertThatThrownBy(arithmetic).isInstanceOf(NullPointerException.class);
        }

        @DisplayName("not be invalid")
        @Test
        void givenInvalidOperator_arithmetic_shouldThrowException() {
            // given
            int a = 0;
            int b = 0;
            String operator = "invalid";

            // when
            ThrowableAssert.ThrowingCallable arithmetic = () -> arithmeticFunction.arithmetic(a, b, operator);

            // then
            assertThatThrownBy(arithmetic).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("can be")
        @ParameterizedTest(name = "{0}")
        @ValueSource(strings = {"add", "subtract", "multiply", "divide"})
        void givenValidOperator_arithmetic_shouldNotThrowException(String operator) {
            // given
            int a = 1;
            int b = 1;

            // when
            ThrowableAssert.ThrowingCallable arithmetic = () -> arithmeticFunction.arithmetic(a, b, operator);

            // then
            assertThatNoException().isThrownBy(arithmetic);
        }

    }

    @DisplayName("should add numbers")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({"1,2,3", "2,3,5"})
    void givenAddAsOperator_arithmetic_shouldReturnSumOfOperands(int a, int b, int sum) {
        // given
        String operator = "add";

        // when
        int result = arithmeticFunction.arithmetic(a, b, operator);

        // then
        assertThat(result).isEqualTo(sum);
    }

    @DisplayName("should subtract numbers")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({"1,2,-1", "3,2,1"})
    void givenSubtractAsOperator_arithmetic_shouldReturnDifferenceOfOperands(int a, int b, int difference) {
        // given
        String operator = "subtract";

        // when
        int result = arithmeticFunction.arithmetic(a, b, operator);

        // then
        assertThat(result).isEqualTo(difference);
    }

    @DisplayName("should multiply numbers")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({"1,2,2", "2,3,6"})
    void givenMultiplyAsOperator_arithmetic_shouldReturnProductOfOperands(int a, int b, int product) {
        // given
        String operator = "multiply";

        // when
        int result = arithmeticFunction.arithmetic(a, b, operator);

        // then
        assertThat(result).isEqualTo(product);
    }

    @DisplayName("should divide numbers")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({"10,2,5", "4,3,1"})
    void givenDivideAsOperator_arithmetic_shouldReturnRatioOfOperands(int a, int b, int ratio) {
        // given
        String operator = "divide";

        // when
        int result = arithmeticFunction.arithmetic(a, b, operator);

        // then
        assertThat(result).isEqualTo(ratio);
    }

    @DisplayName("can't divide by zero")
    @Test
    void givenDivisionByZero_arithmetic_shouldThrowException() {
        // given
        int a = 0;
        int b = 0;
        String operator = "divide";

        // when
        ThrowableAssert.ThrowingCallable arithmetic = () -> arithmeticFunction.arithmetic(a, b, operator);

        // then
        assertThatThrownBy(arithmetic).isInstanceOf(ArithmeticException.class);
    }

}
