package com.daitamer.Record.Shop.API.service;

import com.daitamer.Record.Shop.API.model.Album;
import com.daitamer.Record.Shop.API.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AlbumService {

    List<Album> getAllAlbums();

    Album saveAlbum(Album album);

    Optional<Album> getAlbumById(Long id);

    void deleteAlbum(Long id);

}
