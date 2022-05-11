package ru.itmo.lab.repository.hendlers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import ru.itmo.lab.entity.Dragon;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class XMLReader {
    public static StringBuilder readFromXML () throws IOException {
        String file = System.getenv("DATA_FILEPATH");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        StringBuilder dataXML = new StringBuilder();
        int i;
        while((i = bis.read())!= -1){
            dataXML.append(i);
        }
        bis.close();

        XStream xStream = new XStream();
        xStream.processAnnotations(Dragon.class);
        xStream.addPermission(AnyTypePermission.ANY);


        return dataXML;
    }
}
