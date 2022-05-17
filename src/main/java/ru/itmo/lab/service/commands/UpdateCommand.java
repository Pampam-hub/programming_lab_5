package ru.itmo.lab.service.commands;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;
import ru.itmo.lab.repository.factories.ConsoleDragonFactory;
import ru.itmo.lab.repository.factories.ScriptDragonFactory;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;


public class UpdateCommand extends Command {
    public UpdateCommand() {
        super("update","update element from collection",
                "id");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, getArgs().size());
            if(isExecutedScript()) {
                ScriptDragonFactory scriptDragonFactory = new ScriptDragonFactory(getScanner());
                scriptDragonFactory.generateDragonData();
                Dragon dragon = scriptDragonFactory.getDragon();
                storage.update(Integer.parseInt(args[0]), dragon);
            } else {
                ConsoleDragonFactory consoleDragonFactory = new ConsoleDragonFactory();
                consoleDragonFactory.generateDragonData();
                Dragon dragon = consoleDragonFactory.getDragon();
                storage.update(Integer.parseInt(args[0]), dragon);
            }
            return new CommandResultBuilder()
                    .setMessage("Collection has been update")
                    .setStatus(CommandStatus.SUCCESSFUL).build();
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }

    }
}
