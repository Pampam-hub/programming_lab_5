package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.CommandStatus;
import ru.itmo.lab.service.validator.DragonValidator;


public class HelpCommand extends Command {

    public HelpCommand(String name, String description, String descriptionOfArgs) {
        super("help", "help on available commands",
                "arguments aren't needed");
    }

    // DIY lib
    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validatingNumberOfArgs(args, getArgs().size());
            return null;
        } catch (IllegalArgumentException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }

    }
}
