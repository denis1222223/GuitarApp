package com.example.denis.guitarapp.model;

public class Artist {
    public final int id;
    public final String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
