package com.daitamer.Record.Shop.API.service;

import com.daitamer.Record.Shop.API.model.Album;
import com.daitamer.Record.Shop.API.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }
//
//    @Override
//    public Album saveAlbum(Album album) {
//        return null;
//    }
//
//    @Override
//    public void deleteAlbum(Long id) {
//
//    }
}
