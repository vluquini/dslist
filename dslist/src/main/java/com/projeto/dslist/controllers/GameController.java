package com.projeto.dslist.controllers;

import com.projeto.dslist.dtos.GameDTO;
import com.projeto.dslist.dtos.GameMinDTO;
import com.projeto.dslist.repositories.GameRepository;
import com.projeto.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;//*****

    @PostMapping
    public GameDTO createGame(@RequestBody GameDTO gameDTO) {
        return gameService.createGame(gameDTO);
    }

    @PutMapping("/{id}")
    public GameDTO updateGame(@PathVariable Long id, @RequestBody GameDTO updatedGameDTO){
        return gameService.updateGame(id, updatedGameDTO);
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
            return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findAll(@PathVariable Long id){
        return gameService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGame(@PathVariable Long id){
        gameService.deleteGame(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}