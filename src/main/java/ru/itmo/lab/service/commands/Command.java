package ru.itmo.lab.serviсe.commands;

import ru.itmo.lab.repository.Storage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class Command {
    private String name;
    private String description;
    private List<String> args;

    // commandEntry(всякая шняга типа кто дал аргументы и пипипи ду)

    public Command(String name, String description, String... args){
        this.name = name;
        this.description = description;
        this.args = Arrays.asList(args);
    }

    public abstract CommandResult execute(Storage storage, Map<String, String> mapArgs);

}
