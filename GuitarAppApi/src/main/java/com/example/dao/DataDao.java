package com.example.dao;

import com.example.domain.Song;
import java.util.List;

public interface DataDao {
    public boolean addEntity(Song song);
    public Song getEntityById(Integer id);
    public List<Song> getEntityList();
    public boolean deleteEntity(Integer id);
}
