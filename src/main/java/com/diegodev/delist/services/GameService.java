package com.diegodev.delist.services;

import com.diegodev.delist.dto.GameMinDto;
import com.diegodev.delist.entities.Game;
import com.diegodev.delist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll(){

        return gameRepository.findAll()
                .stream().map(game -> new GameMinDto(
                        game.getId(),
                        game.getTitle(),
                        game.getYear(),
                        game.getImgUrl(),
                        game.getShortDescription())).toList();
    }
}
