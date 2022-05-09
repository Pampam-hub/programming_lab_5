package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;

import java.util.Arrays;
import java.util.List;

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

    public abstract CommandResult execute(Storage storage, String[] args)
            throws EntityNotFoundException;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getArgs() {
        return args;
    }
}
