package com.diegodev.delist.services;

import com.diegodev.delist.dto.GameDto;
import com.diegodev.delist.dto.GameListDto;
import com.diegodev.delist.dto.GameMinDto;
import com.diegodev.delist.repositories.GameListRepository;
import com.diegodev.delist.repositories.GameRepository;
import com.diegodev.delist.services.exceptions.GameExceptionNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true) //usado em metodos de leituras como get, e que a operação seja feita corretamente
    public List<GameListDto> findAll(){

        return gameListRepository.findAll()
                .stream().map(game -> new GameListDto(
                        game.getId(),
                        game.getName())).toList();
    }
}
