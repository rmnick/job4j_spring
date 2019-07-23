package ru.job4j.storage;

import java.util.List;

public interface IStorage<V> {
    V add(V item);
    V update(V item);
    V delete(V item);
    V get(V item);
    List<V> getAll();
}
