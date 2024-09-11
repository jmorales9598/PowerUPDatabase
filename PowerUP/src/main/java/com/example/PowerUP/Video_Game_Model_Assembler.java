package com.example.PowerUP;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class Video_Game_Model_Assembler implements RepresentationModelAssembler<Video_Game, EntityModel<Video_Game>> {

    @Override
    public EntityModel<Video_Game> toModel(Video_Game game){

        return EntityModel.of(game,
                linkTo(methodOn(Video_Game_Controller.class).getById(game.getId())).withSelfRel(),
                linkTo(methodOn(Video_Game_Controller.class).getAllGames()).withRel("games"));
    }

}
