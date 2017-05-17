package com.example.controller;

import com.example.domain.Artist;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import java.util.List;

@RestController
public class ArtistController {

    private final DataService<Artist> dataService;

    public ArtistController(DataService<Artist> dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "artist", method = GET)
    public List<Artist> getArtists() {
        return dataService.getAll();
    }

    @RequestMapping(value = "artist/{id}", method = GET)
    public Artist getArtist(@PathVariable Integer id) {
        return (Artist)dataService.get(id);
    }

    @RequestMapping(value = "artist/{id}", method = DELETE)
    public void deleteArtist(@PathVariable Integer id) {
        dataService.delete(id);
    }

    @RequestMapping(value = "artist", method = POST)
    public @ResponseBody
    void createArtist(@RequestBody Artist artist) {
        dataService.create(artist);
    }

    @RequestMapping(value="artist", method=PUT)
    public void updateArtist(@RequestBody Artist artist) {
        dataService.update(artist);
    }
}
