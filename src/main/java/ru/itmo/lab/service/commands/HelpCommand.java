package ru.itmo.lab.serviсe.commands;

import ru.itmo.lab.repository.Storage;

import java.util.Map;

public class HelpCommand extends Command {

    public HelpCommand(String name, String description, String descriptionOfArgs) {
        super("help", "display help on available commands",
                "arguments aren't needed");
    }

    // DIY lib
    @Override
    public CommandResult execute(Storage storage, Map<String, String> mapArgs) {
        return null;
    }
}
