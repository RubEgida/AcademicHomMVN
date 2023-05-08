package org.example.homework_19.repository;

import java.util.Set;

public interface GeneralPer<T> {
    T getById(int id);
    Set<T> getAll();
    Set<T> get(int offset, int perPage, String sort);
    T save(T passenger);
    T update(T passenger);
    void delete(int passengerId);

}
