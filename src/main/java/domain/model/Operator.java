package domain.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private static final Map<String, Operator> lookup =
            Map.of(PLUS.operator, PLUS, MINUS.operator, MINUS, DIVIDE.operator, DIVIDE, MULTIPLY.operator, MULTIPLY);

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator from(String operator) {
        return Optional.ofNullable(lookup.get(operator))
                .orElseThrow(() -> new IllegalArgumentException("잘못된 Operator"));
    }
}
