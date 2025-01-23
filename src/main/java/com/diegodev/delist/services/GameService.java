package com.diegodev.delist.services;

import com.diegodev.delist.dto.GameDto;
import com.diegodev.delist.dto.GameMinDto;
import com.diegodev.delist.entities.Game;
import com.diegodev.delist.projections.GameMinProjection;
import com.diegodev.delist.repositories.GameRepository;
import com.diegodev.delist.services.exceptions.GameExceptionNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) //usado em metodos de leituras como get, e que a operação seja feita corretamente
    public List<GameMinDto> findAll(){

        return gameRepository.findAll()
                .stream().map(game -> new GameMinDto(
                        game.getId(),
                        game.getTitle(),
                        game.getYear(),
                        game.getImgUrl(),
                        game.getShortDescription())).toList();
    }

    @Transactional(readOnly = true)
    public GameDto findById(final Long id){
        var game = gameRepository.findById(id);

        return game.map(x -> new GameDto(
                x.getId(),
                x.getTitle(),
                x.getYear(),
                x.getGenre(),
                x.getPlatforms(),
                x.getScore(),
                x.getImgUrl(),
                x.getShortDescription(),
                x.getLongDescription()))
                .orElseThrow(() -> new GameExceptionNotFound("Game não encontrado com o id: " + id + "!"));
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(final Long id){
        return gameRepository.searchByList(id)
                .stream().map(gameMinProjection -> new GameMinDto(
                        gameMinProjection.getId(),
                        gameMinProjection.getTitle(),
                        gameMinProjection.getYear(),
                        gameMinProjection.getImgUrl(),
                        gameMinProjection.getShortDescription()
                        )).toList();
    }
}
