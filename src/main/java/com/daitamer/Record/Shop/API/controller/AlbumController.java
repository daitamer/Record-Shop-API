package com.daitamer.Record.Shop.API.controller;

import com.daitamer.Record.Shop.API.model.Album;
import com.daitamer.Record.Shop.API.service.AlbumService;
import com.daitamer.Record.Shop.API.service.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

//    get all albums
    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }


////    get album by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Album> getAlbumById(@PathVariable Long id){
//
//    }
//
////    create album
//    @PostMapping
//    public ResponseEntity<Album> createAlbum(@RequestBody Album album){
//
//    }
//
////    update album
//    @PutMapping
//    @PostMapping("/{id}")
//    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album album){
//
//    }
//
////    delete album by id
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAlbumById(){
//
//    }


}
