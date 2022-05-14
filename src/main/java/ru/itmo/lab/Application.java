package ru.itmo.lab;


import ru.itmo.lab.repository.DragonTreeMapStorage;
import ru.itmo.lab.repository.Storage;
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

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
