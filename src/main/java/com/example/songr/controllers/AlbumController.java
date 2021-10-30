package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping(value = "/staticalbums")
    public String getAlbum(Model model){
        ArrayList<Album> albumList= new ArrayList<>();
        Album b1 = new Album("album 1","artist 1", 6,22,"img 1");
        Album b2 = new Album("album 2","artist 2", 4,66,"img 2");
        Album b3 = new Album("album 3","artist 3", 8,44,"img 3");
        albumList.add(b1);
        albumList.add(b2);
        albumList.add(b3);
        model.addAttribute("albumList",albumList);
        return "albums";

    }

    @GetMapping("/albums")
    public String getDBAlbum(Model model){
        ArrayList<Album> albumList = (ArrayList<Album>) albumRepository.findAll();
        model.addAttribute("albumList",albumList);
        return "albums";
    }

    @GetMapping("/addalbum")
    public String addAlbum(){
        return "addAlbum";
    }

    @PostMapping("/addalbum")
    public RedirectView addAlbum(Model model, @RequestParam(value="title") String title,@RequestParam(value="artist") String artist,
                                              @RequestParam(value="songCount") int songCount, @RequestParam(value="length") int length,
                                              @RequestParam(value="imageUrl") String imageUrl){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

//    @GetMapping("/albumDetails/{id}")
//    public String getAlbumDetails(){
//        return "albumDetails";
//    }

    @GetMapping("/albumDetails/{id}")
    public String getOneAlbum(Model model,@PathVariable int id){
        model.addAttribute("oneAlbum", albumRepository.findById(id).get());
        return "albumDetails";
    }

}
