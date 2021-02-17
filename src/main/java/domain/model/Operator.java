package domain.model;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }
}
