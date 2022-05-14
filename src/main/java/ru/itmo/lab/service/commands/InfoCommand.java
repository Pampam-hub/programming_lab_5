package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;


public class InfoCommand extends Command{
    public InfoCommand() {
        super("info","you can see info about the collection",
                "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, getArgs().size());
            storage.readAll();
            return new CommandResult("here you're collection", CommandStatus.SUCCESSFUL);
        } catch (IllegalArgumentException e) {
        return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
    }
    }
}
