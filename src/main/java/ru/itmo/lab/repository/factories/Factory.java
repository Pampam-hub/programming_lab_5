package ru.itmo.lab.repository.generators;

import ru.itmo.lab.entity.DragonCharacter;
import ru.itmo.lab.entity.DragonType;

public abstract class Generator {
    String name;
    long x;
    float y;
    Integer age;
    int wingSpan;
    DragonType dragonType;
    DragonCharacter dragonCharacter;
    double eyesCount;
}
