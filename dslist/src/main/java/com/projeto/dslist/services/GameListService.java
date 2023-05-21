package com.projeto.dslist.services;

import com.projeto.dslist.dtos.GameListDTO;
import com.projeto.dslist.entities.GameList;
import com.projeto.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true) // boa prática
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        // para cada objeto "x" da lista original, cria-se um novo "x" GameListDTO
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

}

