package ru.itmo.lab.service.handlers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.security.AnyTypePermission;
import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.Storage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class XMLReader {
    public static void readFromXML(String file, Storage storage) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        StringBuilder dataXML = new StringBuilder();
        int i;
        while ((i = bis.read()) != -1) {
            dataXML.append((char) i);
        }
        bis.close();

        XStream xStream = new XStream();
        xStream.processAnnotations(Dragon.class);
        xStream.alias("dragons", Dragon[].class);
        xStream.addPermission(AnyTypePermission.ANY);


        Dragon[] dragons = null;
        try {
            dragons = (Dragon[]) xStream.fromXML(dataXML.toString());
            FileChecker.fileIsCorrect(dragons);
        } catch (ConversionException e) {
            System.out.println("can't parse file, data is incorrect");
            System.exit(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        for (Dragon dragon : dragons) {
            storage.save(dragon);
        }

    }


}
