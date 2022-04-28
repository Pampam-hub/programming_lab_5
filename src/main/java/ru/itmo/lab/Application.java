package ru.itmo.lab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Application {
    public static void main(String[] args) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        Dragon dragon = new Dragon("Nikita", 20);
        String xml = mapper.writeValueAsString(dragon);
        System.out.println(xml);
        Dragon value = mapper.readValue(xml, Dragon.class);
        System.out.println(value);
    }
}
