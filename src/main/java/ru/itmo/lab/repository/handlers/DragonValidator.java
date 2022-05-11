package ru.itmo.lab.repository.hendlers;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class DragonValidator<T> {
    private String string;
    private T value;

    public DragonValidator(Scanner scanner) {
        try {
            this.string = scanner.nextLine();

        } catch (NoSuchElementException e) {
            System.out.println("invalid character entered");
            System.exit(1);
        }
    }

    public static void validatingNumberOfArgs(String[] args, int numberOfArgs) {
        if (args.length != numberOfArgs) {
            throw new IllegalArgumentException("wrong number of arguments, " +
                    "this command expects" + numberOfArgs + " arguments");
        }
    }

    public void validatingNull (boolean nullable) {
        if ("".equals(string)) {
            if (nullable)
                value = null;
            else
                throw new IllegalArgumentException("value can't be null");
        }
    }

    public void validatingFunction(Function<String, T> function, String description) {
        if (!"".equals(string)) {
            try {
                value = function.apply(string);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Error, " + description);
            }
        }
    }

    public void  validatingPredicate(Predicate<Object> predicate, String error) {
        if (!"".equals(string)) {
            if (!predicate.test(value)) {
                throw new IllegalArgumentException(error);
            }
        }
    }

    public T getValue() {
        if (value.getClass().equals(String.class) && !"".equals(string)) {
            value = (T) string;
        }
        return value;
    }
}
