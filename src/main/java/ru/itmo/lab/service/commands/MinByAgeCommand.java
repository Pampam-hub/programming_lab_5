package ru.itmo.lab.service.commands;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.comparators.DragonAgeComparator;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;

public class MinByAgeCommand extends Command {
    public MinByAgeCommand() {
        super("min_by_age","you can see element with the smallest age",
                "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, 0);
            Dragon dragon = (Dragon) storage.min(new DragonAgeComparator());
            CommandResult commandResult = new CommandResultBuilder()
                    .setMessage("Here element with the smallest age")
                    .setStatus(CommandStatus.SUCCESSFUL)
                    .setDragon(dragon).build();

            return commandResult;
        } catch (IllegalArgumentException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }
    }
}
