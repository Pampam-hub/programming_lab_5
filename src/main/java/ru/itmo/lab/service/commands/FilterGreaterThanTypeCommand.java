package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.comparators.DragonTypeComparator;
import ru.itmo.lab.service.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;

public class FilterGreaterThanTypeCommand extends Command {
    public FilterGreaterThanTypeCommand() {
        super("filter_greater_than_type","you can see elements that " +
                "have greater type than specified", "type");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, getArgs().size());
            DragonTypeComparator dragonTypeComparator = new DragonTypeComparator();
            storage.sortDragons(dragonTypeComparator);
            return new CommandResult("here elements with greater type",
                    CommandStatus.SUCCESSFUL);
        } catch (IllegalArgumentException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }
    }
}
