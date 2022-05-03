package ru.itmo.lab.servise.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Command {
    private String name;
    private String description;
    private String descriptionOfArgs;
    private List<String> args = new ArrayList<>();

    // commandEntry(всякая шняга типа кто дал аргументы и пипипи ду)

    public Command(String name, String description, String descriptionOfArgs){
        this.name = name;
        this.description = description;
        this.descriptionOfArgs = descriptionOfArgs;
    }

    public abstract CommandResult execute(Map<String, String> mapArgs);

}
