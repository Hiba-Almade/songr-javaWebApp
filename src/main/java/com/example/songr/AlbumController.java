package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {

    @GetMapping(value = "/albums")
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
}
