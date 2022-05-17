package ru.itmo.lab.service.commands;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;

import java.util.List;


public class ShowCommand extends Command {
    public ShowCommand() {
        super("show","you can see elements of the collection",
                "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, 0);
            CommandResult commandResult = new CommandResultBuilder()
                    .setMessage("Here your collection")
                    .setStatus(CommandStatus.SUCCESSFUL)
                    .setListOfDragons(storage.readAll()).build();

            return commandResult;
        } catch (IllegalArgumentException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }

    }
}
