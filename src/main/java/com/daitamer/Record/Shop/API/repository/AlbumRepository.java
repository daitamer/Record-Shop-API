package com.daitamer.Record.Shop.API.repository;

import com.daitamer.Record.Shop.API.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

}
