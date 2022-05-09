package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.CommandStatus;
import ru.itmo.lab.service.validator.DragonValidator;


public class InsertCommand extends Command {
    public InsertCommand() {
        super("insert","add a new element " +
                        "to the collection", "id");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {

        try {
            DragonValidator.validatingNumberOfArgs(args, getArgs().size());
            // check whether collection already has this element
            // suggest user to add
            return new CommandResult("element has been added",
                    CommandStatus.SUCCESSFUL);
        } catch (IllegalArgumentException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }
    }
}
