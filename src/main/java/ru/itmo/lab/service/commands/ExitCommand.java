package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;


public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit", "exit the program without " +
                "saving", "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, 0);
            return new CommandResultBuilder()
                    .setMessage("Completion the program")
                    .setStatus(CommandStatus.SUCCESSFUL)
                    .setExit().build();
        } catch (IllegalArgumentException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }
    }
}
