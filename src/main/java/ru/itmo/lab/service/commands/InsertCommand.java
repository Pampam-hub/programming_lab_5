package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.exceptions.EntityAlreadyExistsException;
import ru.itmo.lab.repository.factories.ConsoleDragonFactory;
import ru.itmo.lab.repository.factories.ScriptDragonFactory;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;


public class InsertCommand extends Command {
    public InsertCommand() {
        super("insert","add a new element " +
                        "to the collection", "id");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {

        try {
            DragonValidator.validateNumberOfArgs(args, getArgs().size());

            if(isExecutedScript()) {
                ScriptDragonFactory scriptDragonFactory = new ScriptDragonFactory(getScanner());
                scriptDragonFactory.generateDragonData();
                storage.addElement(Integer.parseInt(args[0]), scriptDragonFactory.getDragon());
            } else {
                ConsoleDragonFactory consoleDragonFactory = new ConsoleDragonFactory();
                consoleDragonFactory.generateDragonData();
                storage.addElement(Integer.parseInt(args[0]), consoleDragonFactory.getDragon());
            }
            return new CommandResultBuilder()
                    .setMessage("Element has been added")
                    .setStatus(CommandStatus.SUCCESSFUL).build();
        } catch (IllegalArgumentException | EntityAlreadyExistsException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }
    }
}
