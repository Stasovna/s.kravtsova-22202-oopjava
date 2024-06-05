package commands;

import session.CalculationSession;
import exceptions.NEmptyStackException;
import java.util.EmptyStackException;

public class Print implements Command {
    public void execute(CalculationSession context, String[] args) throws NEmptyStackException {
        try {
            System.out.println(context.peek());
        } catch (EmptyStackException e) {
            throw new NEmptyStackException("Stack is empty, no numbers.\n", e);
        }
    }
}