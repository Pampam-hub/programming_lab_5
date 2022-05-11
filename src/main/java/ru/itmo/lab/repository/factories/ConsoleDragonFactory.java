package ru.itmo.lab.repository.factories;

import ru.itmo.lab.entity.*;
import ru.itmo.lab.repository.validator.DragonValidator;

import java.util.Scanner;

public class DragonFactory extends Factory {

    public DragonFactory(Scanner scanner) {
        super(scanner);
    }

    void generateDragonData() {
        setValue("Enter dragon name:", this::setName);
        setValue("Enter x coordinate, value must be an integer", this::setX);
        setValue("Enter y coordinate, value must be a number", this::setY);
        setValue("Enter dragon age, value must be a positive number", this::setAge);
        setValue("Enter dragon wingspan, value must be an integer positive " +
                "number, if you want to leave this field null - press enter", this::setWingspan);
        setValue("Enter dragon type, available values: " +
                DragonType.show(), this::setDragonType);
        setValue("Enter dragon character, available values: " +
                DragonCharacter.show(), this::setDragonCharacter);
        setValue("Enter count of dragon eyes, value must be a positive number, " +
                "if you want to leave this field null - press enter", this::setEyesCount);
    }

    void setValue(String message, Runnable runnable) {
        System.out.println(message);
        boolean isRunning = true;
        while (isRunning) {
            try {
                runnable.run();
                isRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + "repeat input");
            }

        }
    }

    void setName() throws IllegalArgumentException {
        DragonValidator<String> dragonValidator = new DragonValidator<>(super.scanner);
        dragonValidator.validatingNull(false);
        super.name = dragonValidator.getValue();
    }

    void setX() throws IllegalArgumentException {
        DragonValidator<Long> dragonValidator = new DragonValidator<>(super.scanner);
        dragonValidator.validatingNull(false);
        dragonValidator.validatingFunction(Long::parseLong,
                "value of x must be an integer");
        super.x = dragonValidator.getValue();
    }

    void setY() throws IllegalArgumentException {
        DragonValidator<Float> dragonValidator = new DragonValidator<>(super.scanner);
        dragonValidator.validatingNull(false);
        dragonValidator.validatingFunction(Float::parseFloat,
                "value of y must be a number");
        super.y = dragonValidator.getValue();
    }

    void setAge() throws IllegalArgumentException {
        DragonValidator<Integer> dragonValidator = new DragonValidator<>(super.scanner);
        dragonValidator.validatingNull(false);
        dragonValidator.validatingFunction(Integer::parseInt,
                "value of age must be an integer ");
        dragonValidator.validatingPredicate(arg -> (int) arg > 0,
                "value of age must be a positive");
        super.age = dragonValidator.getValue();
    }

    void setWingspan() throws IllegalArgumentException {
        DragonValidator<Integer> dragonValidator = new DragonValidator<>(super.scanner);
        dragonValidator.validatingNull(false);
        dragonValidator.validatingFunction(Integer::parseInt,
                "value of wingspan must be an integer ");
        dragonValidator.validatingPredicate(arg -> (int) arg > 0,
                "value of age must be a positive");
        super.wingspan = dragonValidator.getValue();
    }

    void setDragonType() throws IllegalArgumentException {
        DragonValidator<DragonType> dragonValidator = new DragonValidator<>(super.scanner);
        dragonValidator.validatingNull(false);
        dragonValidator.validatingFunction(DragonType::valueOf, "value of dragon type " +
                "must be from list " + DragonType.show() + " letter case must be the same");
        super.dragonType = dragonValidator.getValue();
    }

    void setDragonCharacter() throws IllegalArgumentException {
        DragonValidator<DragonCharacter> dragonValidator = new DragonValidator<>(super.scanner);
        dragonValidator.validatingNull(false);
        dragonValidator.validatingFunction(DragonCharacter::valueOf, "value of dragon character " +
                "must be from list " + DragonType.show() + " letter case must be the same");
        super.dragonCharacter = dragonValidator.getValue();
    }

    void setEyesCount() throws IllegalArgumentException {
        DragonValidator<Double> dragonValidator = new DragonValidator<>(super.scanner);
        dragonValidator.validatingNull(true);
        dragonValidator.validatingFunction(Double::parseDouble, "count of dragon eyes " +
                "must be a number ");
        dragonValidator.validatingPredicate(arg -> (int) arg > 0,
                "count of eyes must be a positive");
        super.eyesCount = dragonValidator.getValue();
    }
}
