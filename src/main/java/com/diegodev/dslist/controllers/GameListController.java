package com.diegodev.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodev.dslist.dto.GameListDTO;
import com.diegodev.dslist.dto.GameMinDTO;
import com.diegodev.dslist.services.GameListService;
import com.diegodev.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameListDTO>> findAll(){
		
		List<GameListDTO> list = gameListService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GameListDTO> findById(@PathVariable Long id){
		
		GameListDTO list = gameListService.findById(id);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{listId}/games")
	public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId){
		
		List<GameMinDTO> list = gameService.findByList(listId);
		
		return ResponseEntity.ok().body(list);
	}
}
