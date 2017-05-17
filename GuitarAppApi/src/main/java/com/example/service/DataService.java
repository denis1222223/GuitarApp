package com.example.service;

import java.util.List;

public interface DataService<T> {
    public boolean create(T entity);
    public List<T> getAll();
    public T get(Integer id);
    public boolean update(T entity);
    public boolean delete(Integer id);
}
