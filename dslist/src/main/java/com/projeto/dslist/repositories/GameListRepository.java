package com.projeto.dslist.repositories;

import com.projeto.dslist.entities.Game;
import com.projeto.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
