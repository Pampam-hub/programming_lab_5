package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;
import ru.itmo.lab.service.CommandStatus;
import ru.itmo.lab.service.validator.DragonValidator;


public class SaveCommand extends Command {
    SaveCommand() {
        super("save", "save collection into file",
                "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validatingNumberOfArgs(args, getArgs().size());
            return new CommandResult("collection has been saved",
                    CommandStatus.SUCCESSFUL);
        } catch (IllegalArgumentException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }

    }
}
