import domain.model.Expression;
import view.ExpressionInputView;
import view.ResultOutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ResultOutputView resultOutputView = new ResultOutputView();
        ExpressionInputView expressionInputView = new ExpressionInputView(new Scanner(System.in));

        expressionInputView.getInput()
                .map(Expression::from)
                .map(Expression::calculate)
                .subscribe(resultOutputView::print);
    }
}
