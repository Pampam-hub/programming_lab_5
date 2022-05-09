package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.CommandStatus;
import ru.itmo.lab.service.validator.DragonValidator;

public class MinByAgeCommand extends Command {
    public MinByAgeCommand() {
        super("min_by_age","you can see element with the smallest age",
                "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validatingNumberOfArgs(args, getArgs().size());
            storage.readAll();
            return new CommandResult("here element with the smallest age",
                    CommandStatus.SUCCESSFUL);
        } catch (IllegalArgumentException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }
    }
}
