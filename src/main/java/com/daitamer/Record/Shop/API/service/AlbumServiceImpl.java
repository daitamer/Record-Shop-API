package com.daitamer.Record.Shop.API.service;

import com.daitamer.Record.Shop.API.model.Album;
import com.daitamer.Record.Shop.API.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;


import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }


    @Override
    @Cacheable(value = "albums", key = "#id")
    public Optional<Album> getAlbumById(Long id) {
        System.out.println("Fetching album with id " + id + " from the database");
        return albumRepository.findById(id);
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
