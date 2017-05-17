package com.example.service;

import com.example.dao.DataDao;
import com.example.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class DataServiceImpl<T> implements DataService<T> {

    private final DataDao dataDao;

    @Autowired
    public DataServiceImpl(DataDao<T> dataDao) {
        this.dataDao = dataDao;
    }

    @Override
    public boolean create(T song) {
        return dataDao.add(song);
    }

    @Override
    public boolean update(T song) {
        return dataDao.update(song);
    }

    @Override
    public T get(Integer id) {
        return (T)dataDao.get(id);
    }

    @Override
    public List<T> getAll() {
        return dataDao.getAll();
    }

    @Override
    public boolean delete(Integer id) {
        return dataDao.delete(id);
    }

}
