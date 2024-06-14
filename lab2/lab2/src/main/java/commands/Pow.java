package commands;

import session.CalculationSession;
import exceptions.NEmptyStackException;
import java.util.EmptyStackException;

public class Pow implements Command {
    public void execute(CalculationSession context, String[] args) throws NEmptyStackException {
        try {
            double a = context.pop();
            double b = context.pop();
            context.push(Math.pow(a, b));
        } catch (EmptyStackException e) {
            throw new NEmptyStackException("Stack is empty, no numbers.\n", e);
        }
    }
}
