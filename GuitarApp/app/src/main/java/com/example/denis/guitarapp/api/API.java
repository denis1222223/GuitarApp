package com.example.denis.guitarapp.api;

import android.support.annotation.NonNull;

import com.example.denis.guitarapp.model.Artist;
import com.example.denis.guitarapp.model.Song;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class API {
    public static List<Artist> fetchArtists(int count) {
        List<Artist> artistList = new ArrayList<Artist>();
        for (int i = 0; i < count; i++) {
            artistList.add(createDummyArtist(i));
        }
        return artistList;
    }

    private static Artist createDummyArtist(int index) {
        return new Artist(index, "Artist " + index);
    }

    public static List<Song> fetchSongs(int count) {
        List<Song> songList = new ArrayList<Song>();
        for (int i = 0; i < count; i++) {
            songList.add(createDummySong(i));
        }
        return songList;
    }

    private static Song createDummySong(int index) {
        return new Song(index, "Song " + index);
    }
}
