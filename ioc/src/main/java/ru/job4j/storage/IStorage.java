package ru.job4j.storage;

public interface IStorage<T> extends AutoCloseable {
    T add(T item);
    T get(T item);
}
