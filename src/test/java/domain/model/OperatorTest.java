package domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void from() {
        assertAll(
                () -> assertEquals(Operator.PLUS, Operator.from("+")),
                () -> assertEquals(Operator.MINUS, Operator.from("-")),
                () -> assertEquals(Operator.DIVIDE, Operator.from("/")),
                () -> assertEquals(Operator.MULTIPLY, Operator.from("*")),
                () -> assertThrows(IllegalArgumentException.class, () -> Operator.from("1"))
        );

    }
}