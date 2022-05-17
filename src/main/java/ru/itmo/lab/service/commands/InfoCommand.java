package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;


public class InfoCommand extends Command{
    public InfoCommand() {
        super("info","you can see info about the collection",
                "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, 0);
            CommandResult commandResult = new CommandResultBuilder()
                    .setMessage("Here you're collection: ")
                    .setStatus(CommandStatus.SUCCESSFUL)
                    .setData(storage.getInfo()).build();

            return commandResult;
        } catch (IllegalArgumentException e) {
        return new CommandResultBuilder()
                .setMessage(e.getMessage())
                .setStatus(CommandStatus.UNSUCCESSFUL).build();
    }
    }
}
