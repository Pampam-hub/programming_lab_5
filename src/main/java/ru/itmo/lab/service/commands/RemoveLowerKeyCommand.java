package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
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
            storage.removeLowerKey(Integer.parseInt(args[0]));
            return new CommandResultBuilder()
                    .setMessage("The removal has been completed")
                    .setStatus(CommandStatus.SUCCESSFUL).build();
        } catch (IllegalArgumentException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }

    }
}
