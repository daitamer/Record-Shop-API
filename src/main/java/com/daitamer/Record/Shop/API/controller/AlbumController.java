package com.daitamer.Record.Shop.API.controller;

import com.daitamer.Record.Shop.API.model.Album;
import com.daitamer.Record.Shop.API.service.AlbumService;
import com.daitamer.Record.Shop.API.service.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


//    get album by id
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id){
        return albumService.getAlbumById(id)
                .map(album -> ResponseEntity.ok().body(album))
                .orElse(ResponseEntity.notFound().build());
    }

//    create album
    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody Album album){
        Album createdAlbum = albumService.saveAlbum(album);
        return ResponseEntity.status(201).body(createdAlbum);
    }

//    update album
    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album album){
            return albumService.getAlbumById(id)
                    .map(existingAlbum -> {
                        album.setId(id);
                        Album updatedAlbum = albumService.saveAlbum(album);
                        return ResponseEntity.ok(updatedAlbum);
                    })
                    .orElse(ResponseEntity.notFound().build());
    }
//
////    delete album by id
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAlbumById(){
//
//    }


}
