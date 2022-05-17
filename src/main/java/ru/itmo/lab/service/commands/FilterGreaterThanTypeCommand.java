package ru.itmo.lab.service.commands;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.entity.DragonType;
import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.comparators.DragonTypeComparator;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;

import java.util.List;

public class FilterGreaterThanTypeCommand extends Command {
    public FilterGreaterThanTypeCommand() {
        super("filter_greater_than_type","you can see elements that " +
                "have greater type than specified", "type");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, getArgs().size());
            DragonValidator<DragonType> dragonValidator = new DragonValidator<>(args[0], null);
            dragonValidator.validateNull(false);
            dragonValidator.validateFunction(DragonType::valueOf, "value of dragon type " +
                    "must be from list " + DragonType.show() + " letter case must be the same");
            DragonType type = dragonValidator.getValue();

            List<Dragon> listDragons = storage.sortDragons(new DragonTypeComparator());

            while(type.compareTo(listDragons.get(0).getType()) > 0 ) {
                listDragons.remove(0);
            }

            CommandResult commandResult = new CommandResultBuilder()
                    .setMessage("Here elements with greater type: ")
                    .setStatus(CommandStatus.SUCCESSFUL)
                    .setListOfDragons(listDragons).build();

            return commandResult;
        } catch (IllegalArgumentException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }
    }
}
