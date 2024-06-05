import java.util.Arrays;

public class SplitInput {
    private String commandName;
    private String[] commandArgs;

    public void splitCommand(String command) {
        command = command.trim();
        String[] splitCommand = command.split("\\s");

        commandName = splitCommand[0].toUpperCase();
        commandArgs = Arrays.copyOfRange(splitCommand, 1, splitCommand.length); // аргументы после названия команды
    }

    public String getCommandName() {
        return commandName;
    }

    public String[] getCommandArgs() {
        return commandArgs;
    }
}