package com.example.controller;

import com.example.domain.Song;
import com.example.service.DataService;
import com.example.service.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.util.Date;
import java.util.List;

@RestController
public class SongController {

    private final DataService dataService;

    @Autowired
    public SongController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "song", method = GET)
    public List<Song> getSongs() {
        return dataService.getAll();
    }

    @RequestMapping(value = "song/{id}", method = GET)
    public Song getSong(@PathVariable Integer id) {
        return dataService.get(id);
    }

    @RequestMapping(value = "song/{id}", method = DELETE)
    public void deleteSong(@PathVariable Integer id) {
        dataService.delete(id);
    }

    @RequestMapping(value = "song", method = POST)
    public @ResponseBody
    void createSong(@RequestBody Song song) {
        dataService.create(song);
    }

//    @RequestMapping(value="song", method=PUT)
//    public void updateSong(@RequestBody Song song) {
//        songService.update(song);
//    }
}
