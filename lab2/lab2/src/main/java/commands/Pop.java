package commands;

import session.CalculationSession;
import exceptions.NEmptyStackException;
import java.util.EmptyStackException;

public class Pop implements Command {
    public void execute(CalculationSession context, String[] args) throws NEmptyStackException {
        try {
            context.pop();
        } catch (EmptyStackException e) {
            throw new NEmptyStackException("Stack is empty, no numbers.\n", e);
        }
    }
}