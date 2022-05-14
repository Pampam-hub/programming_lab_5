package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;
import ru.itmo.lab.service.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;


public class RemoveKeyCommand extends Command {
    public RemoveKeyCommand() {
        super("remove_key","remove element from " +
                "collection by key", "id");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args)
            throws EntityNotFoundException {
        try {
            DragonValidator.validateNumberOfArgs(args, getArgs().size());
            storage.remove(args[1]);
            return new CommandResult("the removal has been completed",
                    CommandStatus.SUCCESSFUL);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }
    }
}
