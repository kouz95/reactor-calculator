package domain.model;

import java.util.List;

public class Expression {
    private final List<Integer> numbers;
    private final List<Operator> operators;

    public Expression(List<Integer> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public static Expression from(String expression) {
        return null;
    }

    public float calculate() {
        return 0;
    }
}
