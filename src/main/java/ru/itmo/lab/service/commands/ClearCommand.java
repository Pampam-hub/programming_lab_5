package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.CommandStatus;

import java.util.Map;

public class Clear extends Command {
    public Clear() {
        super("clear","clear all collection",
                "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, Map<String, String> mapArgs) {
        storage.removeAll();
        return new CommandResult("collection has been cleared", CommandStatus.SUCCESSFUL);
    }
}
