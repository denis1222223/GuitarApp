package com.example.service;

import com.example.dao.DataDao;
import com.example.domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    private final DataDao dataDao;

    @Autowired
    public DataServiceImpl(DataDao dataDao) {
        this.dataDao = dataDao;
    }

    @Override
    public boolean create(Song song) {
        return dataDao.addEntity(song);
    }

    @Override
    public Song get(Integer id) {
        return dataDao.getEntityById(id);
    }

    @Override
    public List<Song> getAll() {
        return dataDao.getEntityList();
    }

    @Override
    public boolean delete(Integer id) {
        return dataDao.deleteEntity(id);
    }

}
