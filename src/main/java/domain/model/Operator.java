package domain.model;

import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", Double::sum),
    MINUS("-", (x, y) -> x - y),
    DIVIDE("/", (x, y) -> x / y),
    MULTIPLY("*", (x, y) -> x * y);

    private static final Map<String, Operator> lookup =
            Map.of(PLUS.operator, PLUS, MINUS.operator, MINUS, DIVIDE.operator, DIVIDE, MULTIPLY.operator, MULTIPLY);

    private final String operator;
    private final BinaryOperator<Double> calculate;

    Operator(String operator, BinaryOperator<Double> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public static Operator from(String operator) {
        return Optional.ofNullable(lookup.get(operator))
                .orElseThrow(() -> new IllegalArgumentException("잘못된 Operator"));
    }

    public double operate(double x, double y) {
        return calculate.apply(x, y);
    }
}
