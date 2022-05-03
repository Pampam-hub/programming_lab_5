package ru.itmo.lab.servise.commands;

import java.util.Map;

public class HelpCommand extends Command {

    public HelpCommand(String name, String description, String descriptionOfArgs) {
        super("help", "display help on available commands",
                "arguments aren't needed");
    }

    // DIY lib
    @Override
    public CommandResult execute(Map<String, String> mapArgs) {
        return null;
    }
}
