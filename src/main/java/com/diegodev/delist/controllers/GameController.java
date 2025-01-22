package com.diegodev.delist.controllers;

import com.diegodev.delist.dto.GameMinDto;
import com.diegodev.delist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDto>> findAll(){
        return ResponseEntity.ok(gameService.findAll());
    }
}
