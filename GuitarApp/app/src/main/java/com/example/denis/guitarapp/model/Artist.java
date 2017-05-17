package com.example.denis.guitarapp.model;

public class Artist {
    public int id;
    public String name;

    public Artist() { }

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
