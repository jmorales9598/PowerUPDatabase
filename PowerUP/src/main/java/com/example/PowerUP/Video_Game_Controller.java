package com.example.PowerUP;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@RequestMapping(path ="games")
@RestController
public class Video_Game_Controller {
    @Autowired
    private final Video_Game_Repository gameRepository;

    @Autowired
    private final Video_Game_Model_Assembler gameAssembler;

    public Video_Game_Controller(Video_Game_Repository gameRepository, Video_Game_Model_Assembler gameAssembler) {
        this.gameRepository = gameRepository;
        this.gameAssembler = gameAssembler;
    }

    @PostMapping(path="/add")
    public Video_Game addNewGame(@RequestBody Video_Game newGame){
        return gameRepository.save(newGame);
    }

    @RequestMapping(method = RequestMethod.GET)
    public EntityModel<Video_Game> getByName(@RequestParam(value ="name") String name){
        Video_Game game = gameRepository.findByName(name)
                .orElseThrow(() -> new GameNotFoundException(name));
        return gameAssembler.toModel(game);
    }

    @GetMapping(path="/{Id}")
    public EntityModel<Video_Game> getById(@PathVariable Integer Id){
        Video_Game game = gameRepository.findById(Id)
                .orElseThrow(() -> new GameNotFoundException(Id));
        return gameAssembler.toModel(game);
    }

    @GetMapping(path ="/all")
    public CollectionModel<EntityModel<Video_Game>> getAllGames() {
        List<EntityModel<Video_Game>> gameEntities;
        List<Video_Game> games = (List<Video_Game>) gameRepository.findAll();
        gameEntities = games.stream().map(gameAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(gameEntities, linkTo(methodOn(Video_Game_Controller.class).getAllGames()).withSelfRel());
    }


}
