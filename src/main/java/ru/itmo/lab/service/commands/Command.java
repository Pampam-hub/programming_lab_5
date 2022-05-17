package ru.itmo.lab.service.commands;

import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;
import ru.itmo.lab.service.commandresult.CommandResult;
import ru.itmo.lab.service.handlers.CommandExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Command {
    private String name;
    private String description;
    private List<String> args;
    private static boolean executedScript = false;
    private static Scanner scanner;

    // commandEntry(всякая шняга типа "кто дал аргументы")

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

    public List<String> getArgs() {
        return args;
    }

    public static boolean isExecutedScript() {
        return executedScript;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setExecutedScript(boolean executedScript) {
        Command.executedScript = executedScript;
    }

    public static void setScanner(Scanner scanner) {
        Command.scanner = scanner;
    }

    @Override
    public String toString() {
        return name + " - " + description
                + (args.get(0).equals("arguments aren't needed") ? "" : "\n args: " + args.get(0));
    }
}
