package com.example.denis.guitarapp.model;

import java.util.Date;

public class Song {
    public final int id;
    public final String name;
    public final Date date;
    public final int likesCount;
    public final int artistId;

    public Song(int id, String name, int artistId) {
        this.id = id;
        this.name = name;
        this.date = new Date();
        this.likesCount = 0;
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return name;
    }
}
