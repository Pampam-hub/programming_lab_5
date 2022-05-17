package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.CommandExecutor;
import ru.itmo.lab.service.handlers.DragonValidator;

import java.util.Map;


public class HelpCommand extends Command {

    public HelpCommand() {
        super("help", "help on available commands",
                "arguments aren't needed");
    }

    // DIY lib
    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, 0);
            CommandResult commandResult = new CommandResultBuilder()
                    .setMessage("Available commands: ")
                    .setStatus(CommandStatus.SUCCESSFUL)
                    .setMapOfCommands(CommandExecutor.AVAILABLE_COMMANDS).build();

            return commandResult;
        } catch (IllegalArgumentException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }

    }
}
