package view;

import reactor.core.publisher.Mono;

import java.util.Scanner;

public class ExpressionInputView {
    private final Scanner scanner;

    public ExpressionInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Mono<String> getInput() {
        System.out.println("식을 입력하세요.");
        return Mono.just(scanner.nextLine());
    }
}
