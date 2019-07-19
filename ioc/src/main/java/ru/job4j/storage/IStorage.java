package ru.job4j.storage;

import java.util.List;

public interface IStorage<T> extends AutoCloseable {
    T add(T item);
    T get(T item);
    List<T> getAll();
}
