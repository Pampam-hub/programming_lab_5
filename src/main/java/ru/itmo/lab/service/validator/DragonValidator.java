package ru.itmo.lab.service.validator;

public class DragonValidator {

    public static void validatingNumberOfArgs(String[] args, int numberOfArgs) {
        if (args.length != numberOfArgs) {
            throw new IllegalArgumentException("wrong number of arguments, " +
                    "this command expects" + numberOfArgs + " arguments");
        }
    }
}
