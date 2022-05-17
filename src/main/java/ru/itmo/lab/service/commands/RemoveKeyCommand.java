package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
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
            storage.remove(Integer.parseInt(args[0]));
            return new CommandResultBuilder()
                    .setMessage("The removal has been completed")
                    .setStatus(CommandStatus.SUCCESSFUL).build();
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }
    }
}
