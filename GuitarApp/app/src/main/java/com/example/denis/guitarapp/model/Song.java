package com.example.denis.guitarapp.model;

public class Song {
    public final int id;
    public final String name;

    public Song(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
