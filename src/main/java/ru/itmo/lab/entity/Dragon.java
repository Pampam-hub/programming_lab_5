package ru.itmo.lab.entity;

import java.time.LocalDateTime;

public class Dragon {
    // Поле не может быть nul, Значение > 0, уникальное,
    // генерируется автоматически
    private Integer id;
    // Поле не может быть null, != empty
    private String name;
    // Поле не может быть null
    private Coordinates coordinates;
    // Поле не может быть null, значение генерируется автоматически
    private java.time.LocalDateTime creationDate;
    // Значение поля > 0, поле не может быть null
    private Integer age;
    public final static Integer MAX_AGE = Integer.MAX_VALUE;
    // Значение поля > 0
    private int wingspan;
    public final static int MAX_WINGSPAN = Integer.MAX_VALUE;
    // Поле не может быть null
    private DragonType type;
    // Поле не может быть null
    private DragonCharacter character;
    private DragonHead head;

    public Dragon(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public DragonType getType() {
        return type;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public DragonHead getHead() {
        return head;
    }

    public void setHead(DragonHead head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", wingspan=" + wingspan +
                ", type=" + type +
                ", character=" + character +
                ", head=" + head +
                '}';
    }
}
