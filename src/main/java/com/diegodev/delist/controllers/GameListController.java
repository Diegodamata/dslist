package com.diegodev.delist.controllers;

import com.diegodev.delist.dto.GameDto;
import com.diegodev.delist.dto.GameListDto;
import com.diegodev.delist.dto.GameMinDto;
import com.diegodev.delist.services.GameListService;
import com.diegodev.delist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDto>> findAll(){
        return ResponseEntity.ok(gameListService.findAll());
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDto>> findByList(@PathVariable Long listId){
        return ResponseEntity.ok(gameService.findByList(listId));
    }
}
