package commands;

import session.CalculationSession;
import exceptions.MathException;
import exceptions.NEmptyStackException;
import java.util.EmptyStackException;

public class Div implements Command {
    public void execute(CalculationSession context, String[] args) throws NEmptyStackException, MathException {
        double a, b;
        try {
            a = context.pop();
            b = context.pop();
        } catch (EmptyStackException e) {
            throw new NEmptyStackException("Stack is empty, no numbers.\n", e);
        }
        if (b == 0) {
            throw new MathException("Division by zero.\n");
        }
        context.push(a / b);
    }
}