package ru.itmo.lab.entity;

public enum DragonType {
    WATER,
    UNDERGROUND,
    FIRE;

    public static StringBuilder show() {
        StringBuilder dragonTypes = new StringBuilder("");
        for(DragonType type: values()) {
            dragonTypes.append(type);
            dragonTypes.append(", ");
        }
        return dragonTypes;
    }
}
