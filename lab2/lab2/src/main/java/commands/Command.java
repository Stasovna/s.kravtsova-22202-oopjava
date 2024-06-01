package commands;

import session.CalculationSession;
import exceptions.CommandException;

public interface Command {
    void execute(CalculationSession context, String[] args) throws CommandException;
}