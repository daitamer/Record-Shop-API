package com.daitamer.Record.Shop.API.service;


import com.daitamer.Record.Shop.API.model.Album;
import com.daitamer.Record.Shop.API.model.Genre;
import com.daitamer.Record.Shop.API.repository.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@DataJpaTest
public class AlbumServiceImplTest {

    @Mock
    private AlbumRepository albumRepository;

    @InjectMocks
    private AlbumServiceImpl albumService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAlbums(){

    //Arrange
        Album album1 = new Album(1L, "Album 1", "Artist 1", Genre.ROCK, 1960, 10.0);
        Album album2 = new Album(2L, "Album 2", "Artist 2", Genre.OTHER, 1990, 12.0);
        List<Album> expectedAlbums = Arrays.asList(album1, album2);

        when(albumRepository.findAll()).thenReturn(expectedAlbums);

    //Act
        List<Album> actualAlbums = albumService.getAllAlbums();

    //Assert
        assertEquals(expectedAlbums, actualAlbums);

    }

//    saveAlbum()

    @Test
    void testSaveAlbum() {

        //Arrange
        Album album = new Album(1L, "Album 1", "Artist 1", Genre.ROCK, 1960, 10.0);

        when(albumRepository.save(any(Album.class))).thenReturn(album);

        //Act
        Album savedAlbum = albumService.saveAlbum(album);

        //Assert
        assertNotNull(savedAlbum);
        assertEquals(album.getArtist(), savedAlbum.getArtist());
        assertEquals(album.getGenre(), savedAlbum.getGenre());
        assertEquals(album.getTitle(), savedAlbum.getTitle());
        assertEquals(album.getPrice(), savedAlbum.getPrice());
        assertEquals(album.getReleaseYear(), savedAlbum.getReleaseYear());
        verify(albumRepository, times(1)).save(album);

    }


    @Test
    void testDeleteAlbum(){

    //Arrange
        Long albumId = 1L;

        //Act
        albumService.deleteAlbum(albumId);

        //Assert
        verify(albumRepository, times(1)).deleteById(albumId);

    }




}
