package ru.itmo.lab.repsitory;

import java.util.Comparator;
import java.util.List;

public interface Storage<T, U> {
    T save(T entity);

    T read(U id);

    T update(T entity);

    boolean remove(T entity);

    List<T> readAll();

    <C> T min(Comparator<C> com);

}
