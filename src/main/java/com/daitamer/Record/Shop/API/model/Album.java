package com.daitamer.Record.Shop.API.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

enum Genre {
    ROCK,
    JAZZ,
    CLASSICAL,
    ELECTRONIC,
    POP,
    COUNTRY,
    ALTERNATIVE,
    OTHER
}

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String artist;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Column(name="release_date")
    private LocalDate releaseDate;

    @Column(nullable = false)
    private Double price;

    public Album(){

    }

}
