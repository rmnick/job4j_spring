package ru.job4j.service;

import java.util.List;

public interface IService<V> {
    V add(V item);
    V get(V item);
    V update(V item);
    V delete(V item);
    List<V> getAll();
    List<V> getAllBoth();
    boolean check(V item);
}
