package ru.itmo.lab.repository;

import ru.itmo.lab.entity.Dragon;
import ru.itmo.lab.repository.exceptions.EntityNotFoundException;
import ru.itmo.lab.service.commands.Command;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface Storage<T, U> {
    Dragon save(Dragon entity);

    // T save(T entity);
    T read(U id) throws EntityNotFoundException;
    T update(U id, T entity) throws EntityNotFoundException;
    boolean remove(U id) throws EntityNotFoundException;
    boolean removeLower(U id) throws EntityNotFoundException;
    // if work with clients we need clientName to removeAll
    boolean removeAll();
    List<T> readAll();
    T min(Comparator< Dragon> com);
    List<T> sortDragons(Comparator<Dragon> com);
    void addHistory(Command command);
}
