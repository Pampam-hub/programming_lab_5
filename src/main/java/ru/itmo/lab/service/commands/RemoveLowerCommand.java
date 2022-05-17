package ru.itmo.lab.service.commands;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.factories.ConsoleDragonFactory;
import ru.itmo.lab.repository.factories.ScriptDragonFactory;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;
import ru.itmo.lab.service.handlers.ScriptReader;

public class RemoveLowerCommand extends Command {
    public RemoveLowerCommand() {
        super("remove_lower", "remove elements lower than " +
                "specified from collection", "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, 0);
            if(isExecutedScript()) {
                ScriptDragonFactory scriptDragonFactory = new ScriptDragonFactory(getScanner());
                scriptDragonFactory.generateDragonData();
                Dragon dragon = scriptDragonFactory.getDragon();
                storage.removeLower(dragon);
            } else {
                ConsoleDragonFactory consoleDragonFactory = new ConsoleDragonFactory();
                consoleDragonFactory.generateDragonData();
                Dragon dragon = consoleDragonFactory.getDragon();
                storage.removeLower(dragon);
            }
            return new CommandResultBuilder()
                    .setMessage("The removal has been completed")
                    .setStatus(CommandStatus.SUCCESSFUL).build();
        } catch (IllegalArgumentException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }

    }
}
