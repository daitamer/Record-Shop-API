package com.daitamer.Record.Shop.API.controller;

import com.daitamer.Record.Shop.API.model.Album;
import com.daitamer.Record.Shop.API.model.Genre;
import com.daitamer.Record.Shop.API.service.AlbumService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;


import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AlbumService albumService;

    @Autowired
    private ObjectMapper objectMapper;

    private Album album;

    @BeforeEach
    void setUp(){
        album = new Album(1L, "Album1", "Artist1", Genre.ROCK, 1969, 10.00);
    }

    @Test
    void testGetAllAlbums() throws Exception {
        //arrange
        List<Album> albums = List.of(album);
        given(albumService.getAllAlbums()).willReturn(albums);

        //act
        //assert
        mvc.perform(get("/albums")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(albums)));

        verify(albumService, times(1)).getAllAlbums();
    }


    @Test
    void testGetAlbumById() throws Exception {
        //arrange
        given(albumService.getAlbumById(1L)).willReturn(Optional.of(album));

        //act
        //assert

        mvc.perform(get("/albums/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value(album.getTitle()))
                .andExpect(jsonPath("$.artist").value(album.getArtist()));
    }


    ////    get album by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Album> getAlbumById(@PathVariable Long id){
//    }

}
