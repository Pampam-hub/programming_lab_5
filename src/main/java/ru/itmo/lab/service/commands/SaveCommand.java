package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;
import ru.itmo.lab.service.handlers.XMLWriter;

import java.io.IOException;


public class SaveCommand extends Command {
    public SaveCommand() {
        super("save", "save collection into file",
                "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, 0);
            XMLWriter.writeToXML(storage.readAll());
            return new CommandResultBuilder()
                    .setMessage("Collection has been saved")
                    .setStatus(CommandStatus.SUCCESSFUL).build();
        } catch (IllegalArgumentException | IOException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }

    }
}
