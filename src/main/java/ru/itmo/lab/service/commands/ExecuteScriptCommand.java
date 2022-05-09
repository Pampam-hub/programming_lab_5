package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.CommandStatus;
import ru.itmo.lab.service.validator.DragonValidator;

import java.util.Map;

public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand() {
        super("execute_script","execute script",
                "file_name");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validatingNumberOfArgs(args, getArgs().size());
            return new CommandResult("script has been executed",
                    CommandStatus.SUCCESSFUL);
        } catch(IllegalArgumentException e) {
            return new CommandResult(e.getMessage(), CommandStatus.UNSUCCESSFUL);
        }

    }
}
