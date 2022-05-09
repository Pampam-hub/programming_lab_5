package ru.itmo.lab.repository.generators;

import ru.itmo.lab.entity.*;

import java.util.Scanner;

public class GeneratorDragon {
    private final Scanner scanner = new Scanner(System.in);

    void generateDragonData() {
        setValue("Enter dragon name:", this::setName);
        setValue("Enter X coordinate, value must be an integer " +
                "and less than " + Coordinates.X_MAX, this::setX);
        setValue("Enter Y coordinate, value must be a number " +
                "and less than " + Coordinates.Y_MAX, this::setY);
        setValue("Enter dragon age, value must be a positive number " +
                "and less than " + Dragon.MAX_AGE, this::setAge);
        setValue("Enter dragon wingspan, value must be a positive number " +
                "and less than " + Dragon.MAX_WINGSPAN + "if you want to leave " +
                "this field null, press enter", this::setWingspan);
        setValue("Enter dragon type, available values: " +
                DragonType.show(), this::setDragonType);
        setValue("Enter dragon character, available values: " +
                DragonCharacter.show(), this::setDragonCharacter);
        setValue("Enter count of dragon eyes, value must be a positive number " +
                "and less than " + DragonHead.MAX_EYESCOUNT + "if you want to leave " +
                "this field null, press enter", this::setEyesCount);
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

    }

    void setX() {

    }

    void setY() {

    }

    void setAge() {

    }

    void setWingspan() {

    }

    void setDragonType() {

    }

    void setDragonCharacter() {

    }

    void setEyesCount() {

    }

}
