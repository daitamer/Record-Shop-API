package com.daitamer.Record.Shop.API.controller;

import com.daitamer.Record.Shop.API.model.Album;
import com.daitamer.Record.Shop.API.model.Genre;
import com.daitamer.Record.Shop.API.service.AlbumService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AlbumControllerTest {

    @InjectMocks
    private AlbumController albumController;

    @Autowired
    private MockMvc mvc;

    @Mock
    private AlbumService albumService;

    private Album album;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        album = new Album(1L, "Album1", "Artist1", Genre.ROCK, 1969, 10.00);
        objectMapper = new ObjectMapper();
        mvc = MockMvcBuilders.standaloneSetup(albumController).build();
    }

    @Test
    void testGetAllAlbums() throws Exception {
        //arrange
        List<Album> albums = List.of(album);
//        given(albumService.getAllAlbums()).willReturn(albums);

        when(albumService.getAllAlbums()).thenReturn(albums);

        //act
        //assert
        this.mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/albums")
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

//    @Test
//    void testCreateAlbum() throws Exception {
//
//        given(albumService.saveAlbum(album)).willReturn(album);
//
//        mvc.perform(post("/albums")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(album)))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(objectMapper.writeValueAsString(album)));
//    }

}
