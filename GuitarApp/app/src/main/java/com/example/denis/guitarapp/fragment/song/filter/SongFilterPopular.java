package com.example.denis.guitarapp.fragment.song.filter;

import com.example.denis.guitarapp.model.Song;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SongFilterPopular implements Filter<Song>, Serializable {
    public List<Song> filter(List<Song> songs) {
        Collections.sort(songs, new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
                return s1.likesCount - s2.likesCount;
            }
        });
        return songs.subList(0, 50);
    }
}
