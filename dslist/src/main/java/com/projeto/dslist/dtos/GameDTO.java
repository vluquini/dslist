package com.projeto.dslist.dtos;

import com.projeto.dslist.entities.Game;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class GameDTO {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(){}

    public GameDTO(Game game){
        // BeanUtils permite a copia das propriedades de uma origem para um destino
        // para funcionar, é necessário possuir getters e setters
        BeanUtils.copyProperties(game, this);
    }

}
