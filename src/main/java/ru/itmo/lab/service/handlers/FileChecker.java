package ru.itmo.lab.service.handlers;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.factories.Factory;
import ru.itmo.lab.repository.factories.FileDragonFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileChecker {

    public static void checkFile(String filePath) throws FileNotFoundException {

        File file = new File(filePath);
        if(!file.exists()) {
            throw new FileNotFoundException("file not found");
        } else if(file.isDirectory()) {
            throw new FileNotFoundException("it isn't a file, it's a directory");
        } else if(!file.canRead()) {
            throw new FileNotFoundException("no read  access");
        } else if(!file.canWrite()) {
            throw new FileNotFoundException("no write access");
        }
    }

    static void fileIsCorrect(Dragon[] dragons) {
        List<Integer> ids = new ArrayList<>();
        int maxId = -1;

        for (Dragon dragon : dragons) {
            try {
                if (ids.contains(dragon.getId())) {
                    throw new IllegalArgumentException("the input collection has elements with equal id");
               } else {
                    ids.add(dragon.getId());
                    maxId = Math.max(maxId, dragon.getId());
                }


                Factory factory = new FileDragonFactory(dragon);
                factory.generateDragonData();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }

        dragons[0].setIdCounter(++maxId);


    }
}
