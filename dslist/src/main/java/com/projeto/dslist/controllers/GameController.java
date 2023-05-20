package com.projeto.dslist.controllers;

import com.projeto.dslist.dtos.GameDTO;
import com.projeto.dslist.dtos.GameMinDTO;
import com.projeto.dslist.entities.Game;
import com.projeto.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){
            return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findAll(@PathVariable Long id){
        return gameService.findById(id);
    }

}