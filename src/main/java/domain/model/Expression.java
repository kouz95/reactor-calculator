package domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expression {
    private static final String DELIMITER = " ";

    private final List<Double> numbers;
    private final List<Operator> operators;

    public Expression(List<Double> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
        verify(this.numbers, this.operators);
    }

    public static Expression from(String input) {
        List<String> expression = Arrays.asList(input.split(DELIMITER));

        Map<Boolean, List<String>> numbersAndOperators = IntStream.range(0, expression.size())
                .boxed()
                .collect(Collectors.groupingBy(value -> value % 2 == 1, Collectors.mapping(expression::get, Collectors.toList())));
        return new Expression(
                numbersAndOperators.get(false)
                        .stream()
                        .map(Double::parseDouble)
                        .collect(Collectors.toList()),
                numbersAndOperators.get(true).stream()
                        .map(Operator::from)
                        .collect(Collectors.toList())
        );
    }

    private void verify(List<Double> numbers, List<Operator> operators) {
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException("잘못된 식입니다.");
        }
    }

    public double calculate() {
        AtomicInteger count = new AtomicInteger();
        return numbers.stream()
                .reduce((num1, num2) -> operators.get(count.getAndIncrement()).operate(num1, num2))
                .orElseThrow(IllegalArgumentException::new);
    }
}
