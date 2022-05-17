package ru.itmo.lab;



import ru.itmo.lab.entity.DragonType;
import ru.itmo.lab.repository.DragonTreeMapStorage;
import ru.itmo.lab.repository.Storage;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;
import ru.itmo.lab.service.handlers.ConsoleReader;
import ru.itmo.lab.service.handlers.FileChecker;
import ru.itmo.lab.service.handlers.XMLReader;

import java.io.*;


public class Application {
    public static void main(String[] args) throws IOException {

        String file = System.getenv("DATA_FILEPATH");

        try {
            FileChecker.checkFile(file);
            Storage storage = new DragonTreeMapStorage();
            XMLReader.readFromXML(file, storage);
            System.out.println("\nCollection from file was add successfully");
            ConsoleReader consoleReader = new ConsoleReader();
            consoleReader.readFromConsole(storage);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
