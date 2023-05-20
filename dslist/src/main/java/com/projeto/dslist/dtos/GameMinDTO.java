package com.projeto.dslist.dtos;

import com.projeto.dslist.entities.Game;
import com.projeto.dslist.projections.GameMinProjection;

public record GameMinDTO(
         Long id, String title, Integer year,
         String imgUrl, String shortDescription
) {

    public GameMinDTO(Game game) {
        this(game.getId(), game.getTitle(), game.getYear(),
                game.getImgUrl(), game.getShortDescription());
    }

    public GameMinDTO(GameMinProjection game) {
        this(game.getId(), game.getTitle(), game.getYear(),
                game.getImgUrl(), game.getShortDescription());
    }

}
