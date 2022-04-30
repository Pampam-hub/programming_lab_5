package ru.itmo.lab.repository;

import java.util.Comparator;
import java.util.List;

public class TreeMapStorage<T, U> implements Storage{
    @Override
    public <T>T save(T entity) {

    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Object read(Object id) {
        return null;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }

    @Override
    public boolean remove(Object entity) {
        return false;
    }

    @Override
    public boolean remove(List entities) {
        return false;
    }

    @Override
    public List readAll() {
        return null;
    }

    @Override
    public List findLower(Comparator com) {
        return null;
    }

    @Override
    public Object min(Comparator com) {
        return null;
    }
}
