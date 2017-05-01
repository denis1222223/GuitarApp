package com.example.denis.guitarapp.api;

import com.example.denis.guitarapp.model.Artist;
import com.example.denis.guitarapp.model.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class API {
    private static int artistsCount = 20;
    private static int songsCount = 60;
    private static Random random = new Random();

    public static List<Artist> fetchArtists() {
        List<Artist> artistList = new ArrayList<Artist>();
        for (int i = 0; i < artistsCount; i++) {
            artistList.add(createDummyArtist(i));
        }
        return artistList;
    }

    private static Artist createDummyArtist(int index) {
        return new Artist(index, "Artist " + index);
    }

    public static List<Song> fetchSongs() {
        List<Song> songList = new ArrayList<Song>();
        for (int i = 0; i < songsCount; i++) {
            songList.add(createDummySong(i));
        }
        return songList;
    }

    private static Song createDummySong(int index) {
        return new Song(index, "Song " + index, random.nextInt(artistsCount));
    }
}
