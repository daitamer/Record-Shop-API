package com.daitamer.Record.Shop.API.service;


import com.daitamer.Record.Shop.API.model.Album;
import com.daitamer.Record.Shop.API.model.Genre;
import com.daitamer.Record.Shop.API.repository.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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


    //Act
    //Assert


    }


}
