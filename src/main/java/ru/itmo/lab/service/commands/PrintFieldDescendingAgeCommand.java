package ru.itmo.lab.service.commands;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.comparators.DragonAgeComparator;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;

import java.util.ArrayList;
import java.util.List;

public class PrintFieldDescendingAgeCommand extends Command {
    public PrintFieldDescendingAgeCommand() {
        super("print_field_descending_age","you can see values of field " +
                "age in descending order","arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, 0);
            List<Dragon> dragons = storage.sortDragons(new DragonAgeComparator());
            List<Integer> ages = new ArrayList<>();
            for(Dragon dragon: dragons) {
                ages.add(dragon.getAge());
            }
            CommandResult commandResult = new CommandResultBuilder()
                    .setMessage("Fields age in descending: ")
                    .setStatus(CommandStatus.SUCCESSFUL)
                    .setIntegerList(ages).build();

            return commandResult;
        } catch (IllegalArgumentException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }
    }
}
