package com.example.denis.guitarapp.model;

import java.util.Date;

public class Song {
    public int id;
    public String name;
    public Date date;
    public int likesCount;
    public int artistId;
    public String text;

    public Song() { }

    public Song(int id, String name, int artistId) {
        this.id = id;
        this.name = name;
        this.date = new Date();
        this.likesCount = 0;
        this.artistId = artistId;
        this.text = "";
    }

    @Override
    public String toString() {
        return name;
    }
}
