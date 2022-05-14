package ru.itmo.lab.service.handlers;

import com.thoughtworks.xstream.XStream;
import ru.itmo.lab.entity.Dragon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class XMLWriter {
    public static void writeToXML(TreeMap<Integer, Dragon> dragons) throws IOException {
        String file = System.getenv("DATA_FILEPATH");
        XStream xStream = new XStream();

        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" + xStream.toXML(dragons);
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.write(xmlData);
        printWriter.close();
    }


}
