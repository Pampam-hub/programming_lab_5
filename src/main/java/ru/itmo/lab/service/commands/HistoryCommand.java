package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.commandresult.CommandResultBuilder;
import ru.itmo.lab.service.commandresult.CommandStatus;
import ru.itmo.lab.service.handlers.DragonValidator;

import java.util.Deque;

public class HistoryCommand extends Command{
    public HistoryCommand() {
        super("history", "you can see the last 12 commands " +
                        "you called", "arguments aren't needed");
    }

    @Override
    public CommandResult execute(Storage storage, String[] args) {
        try {
            DragonValidator.validateNumberOfArgs(args, 0);
            CommandResult commandResult = new CommandResultBuilder()
                    .setMessage("Your history:")
                    .setStatus(CommandStatus.SUCCESSFUL)
                    .setDeque(storage.getHistory()).build();

            return commandResult;
        } catch (IllegalArgumentException e) {
            return new CommandResultBuilder()
                    .setMessage(e.getMessage())
                    .setStatus(CommandStatus.UNSUCCESSFUL).build();
        }
    }
}
