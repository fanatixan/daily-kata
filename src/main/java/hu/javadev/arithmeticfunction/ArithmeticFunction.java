package hu.javadev.arithmeticfunction;

import java.util.Objects;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArithmeticFunction {

    private static final Set<String> VALID_OPERATORS = Stream.of(Operation.values())
            .map(Operation::name)
            .map(String::toLowerCase)
            .collect(Collectors.toSet());

    public int arithmetic(int a, int b, String operator) {
        Objects.requireNonNull(operator);

        if (!VALID_OPERATORS.contains(operator)) {
            throw new IllegalArgumentException();
        }

        Operation operation = Operation.valueOf(operator.toUpperCase());
        return operation.apply(a, b);
    }

    private enum Operation {
        ADD(Integer::sum),
        SUBTRACT((a, b) -> a - b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b);

        private final IntBinaryOperator operator;

        Operation(IntBinaryOperator operator) {
            this.operator = operator;
        }

        public int apply(int a, int b) {
            return operator.applyAsInt(a, b);
        }
    }

}
