import commands.Command;
import session.CalculationSession;
import exceptions.CommandException;
import exceptions.CreateCommandException;
import exceptions.NoSuchCommandException;
import factory.CommandsFactory;

import javax.naming.ConfigurationException;

public class Calculator {
    private CalculationSession session;
    private CommandsFactory factory;

    public Calculator() throws ConfigurationException {
        session = new CalculationSession();
        factory = new CommandsFactory();
    }

    public void execute(String commandName, String[] args)
            throws CreateCommandException, NoSuchCommandException, CommandException {
        Command command = factory.produceCommand(commandName);
        command.execute(session, args);
    }
}