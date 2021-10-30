package com.example.songr.controllers;


import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping(value = "/staticSong")
    public String getAlbum(Model model){
        ArrayList<Song> albumList= new ArrayList<>();
        Album album = albumRepository.findById(1).get();
        Song b1 = new Song("song 1",2,5,album);
        Song b2 = new Song("song 2",2,5,album);
        Song b3 = new Song("song 3",2,5,album);

        albumList.add(b1);
        albumList.add(b2);
        albumList.add(b3);
        songRepository.save(b1);
        songRepository.save(b2);
        songRepository.save(b3);
        model.addAttribute("song",albumList);
        return "song";

    }

    @GetMapping(value = "/song")
    public String songs(Model model){
        model.addAttribute("songs",songRepository.findAll());
        return "song";
    }

    @PostMapping("/addSong")
    public RedirectView addAlbum(Model model, @RequestParam(value = "albumId") int albumID,
                                 @RequestParam(value="title") String title,
                                 @RequestParam(value="length") int length,
                                 @RequestParam(value="trackNumber") int trackNumber){
        Album album = albumRepository.findById(albumID).get();
        Song song=new Song(title,length,trackNumber,album);
        songRepository.save(song);
        return new RedirectView("/albumDetails/"+albumID);
    }

}
