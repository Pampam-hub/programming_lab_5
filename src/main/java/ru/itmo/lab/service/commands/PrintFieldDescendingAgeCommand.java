package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.CommandStatus;

public class PrintFieldDescendingAgeCommand extends Command {
    public PrintFieldDescendingAgeCommand() {
        super("print_field_descending_age","you can see values of field " +
                "age in descending order","arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            storage.removeAll();
            return new CommandResult("collection has been cleared",
                    CommandStatus.SUCCESSFUL);
        } catch (IllegalArgumentException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }

    }
}
