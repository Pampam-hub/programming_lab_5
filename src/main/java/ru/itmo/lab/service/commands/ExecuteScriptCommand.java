package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;
import ru.itmo.lab.service.handlers.FileChecker;
import ru.itmo.lab.service.handlers.ScriptReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand() {
        super("execute_script","execute script",
                "file_name");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, getArgs().size());
            String file = args[0];
            FileChecker.checkFile(file);
            setExecutedScript(true);
            ScriptReader scriptReader = new ScriptReader();
            scriptReader.readScript(storage, file);
            setExecutedScript(false);
            storage.deleteFromPreviousFiles(file);
            return new CommandResultBuilder()
                    .setMessage("Script \"" +  file + "\" has been executed")
                    .setStatus(CommandStatus.SUCCESSFUL).build();
        } catch(IllegalArgumentException | FileNotFoundException e) {
            setExecutedScript(false);
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }

    }
}
