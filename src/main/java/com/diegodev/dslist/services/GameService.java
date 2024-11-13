package com.diegodev.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodev.dslist.dto.GameDTO;
import com.diegodev.dslist.dto.GameMinDTO;
import com.diegodev.dslist.entities.Game;
import com.diegodev.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		
		List<Game> list = gameRepository.findAll();
		List<GameMinDTO> dto = list.stream().map(x -> new GameMinDTO(x)).toList();
		
		return dto ;
	}
	
	//é uma boa pratica colocar essa anotação para que o operação com o banco seja concreta (ASID)
	//Quando definido com readOnly = true, ela informa ao Spring que a operação não fará alterações no banco de dados
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		
		Optional<Game> result = gameRepository.findById(id);
		GameDTO dto = new GameDTO(result.get());
		
		return dto;
	}

}
