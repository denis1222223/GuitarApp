package com.example.controller;

import com.example.domain.Artist;
import com.example.domain.Song;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ArtistController {

    @RequestMapping(value = "artist", method = POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody
    void createArtist(@RequestBody Artist artist) {

    }

}
