package factory;

import commands.Command;
import exceptions.CreateCommandException;
import exceptions.NoSuchCommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.ConfigurationException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class CommandsFactory {
    private final HashMap<String, Class<Command>> commandNames;
    private static final Logger logger = LoggerFactory.getLogger(CommandsFactory.class);

    public CommandsFactory() throws ConfigurationException {
        FactoryConfig config = new FactoryConfig();
        config.configure("FactoryConfig.properties");
        commandNames = config.getCommandNames();
    }

    public Command produceCommand(String commandName) throws NoSuchCommandException, CreateCommandException {
        if (commandName == null || !commandNames.containsKey(commandName)) {
            logger.error("Bad name of the command.");
            throw new NoSuchCommandException("Bad name of the command.");
        }

        Command newCommand;
        try {
            newCommand = commandNames.get(commandName).getDeclaredConstructor().newInstance();//создает новый экземпляр класса с помощью конструктора, который был получен на предыдущем шаге
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                 | IllegalArgumentException | InvocationTargetException e) {
            logger.error("Can't create new command. {}", e.getMessage());
            throw new CreateCommandException("Can't create new command. " + e.getMessage());
        }
        return newCommand;
    }
}