package com.example.dao;

import java.util.List;

public interface DataDao<T> {
    public boolean add(T entity);
    public List<T> getAll();
    public T get(Integer id);
    public boolean update(T entity);
    public boolean delete(Integer id);
}
