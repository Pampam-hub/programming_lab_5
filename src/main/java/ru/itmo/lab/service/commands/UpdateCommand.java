package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.CommandStatus;


public class UpdateCommand extends Command {
    public UpdateCommand() {
        super("update","update element from collection",
                "id");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            return new CommandResult("collection has been update",
                    CommandStatus.SUCCESSFUL);
        } catch (IllegalArgumentException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }

    }
}
