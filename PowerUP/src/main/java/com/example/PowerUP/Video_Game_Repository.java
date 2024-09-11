package com.example.PowerUP;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//Creating a CRUD(Create, Read, Update, Delete) Repository to use with SQL
public interface Video_Game_Repository extends CrudRepository<Video_Game, Integer>{

    Optional<Video_Game> findByName(String name);

    Optional<Video_Game> findById(Integer Id);
}
