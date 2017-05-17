package com.example.service;

import com.example.domain.Song;
import java.util.List;

public interface DataService {
    public boolean create(Song song);
    public Song get(Integer id);
    public List<Song> getAll();
    public boolean delete(Integer id);
}
