package com.projeto.dslist.dtos;

import com.projeto.dslist.entities.GameList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList gameList){
        id = gameList.getId();
        name = gameList.getName();
    }

}
