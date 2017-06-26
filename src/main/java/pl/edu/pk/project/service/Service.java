package pl.edu.pk.project.service;

import pl.edu.pk.project.model.Model;

import java.util.List;

public interface Service<T> {
    boolean add(T t);
    T get(String id);
    boolean remove(String id);
    List<T> getAll();
}
