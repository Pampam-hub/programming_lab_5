package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;

public class RemoveLowerKeyCommand extends Command {
    public RemoveLowerKeyCommand() {
        super("remove_lower_key", "remove elements that have key " +
                "lower than specified from collection", "id");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, getArgs().size());
            return new CommandResult("the removal has been completed",
                    CommandStatus.SUCCESSFUL);
        } catch (IllegalArgumentException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }

    }
}
