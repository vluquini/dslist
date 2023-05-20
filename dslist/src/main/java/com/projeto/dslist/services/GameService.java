package com.projeto.dslist.services;

import com.projeto.dslist.dtos.GameDTO;
import com.projeto.dslist.dtos.GameListDTO;
import com.projeto.dslist.dtos.GameMinDTO;
import com.projeto.dslist.entities.Game;
import com.projeto.dslist.projections.GameMinProjection;
import com.projeto.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // boa prática
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
    @Transactional(readOnly = true) // boa prática
    public GameDTO  findById(Long id){
        //o id pode nao existir, entao seria recomendado usar um try catch...
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    //como o retorno é de um Game, o método é implementado aqui
    //mas a operação é de Lista, então a chamada do método está em GameListController.
    @Transactional(readOnly = true) // boa prática
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}

