package com.diegodev.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodev.dslist.dto.GameMinDTO;
import com.diegodev.dslist.entities.Game;
import com.diegodev.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		
		List<Game> list = gameRepository.findAll();
		List<GameMinDTO> dto = list.stream().map(x -> new GameMinDTO(x)).toList();
		
		return dto ;
	}

}
