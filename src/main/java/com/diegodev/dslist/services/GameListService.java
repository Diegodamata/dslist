package com.diegodev.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodev.dslist.dto.GameListDTO;
import com.diegodev.dslist.entities.GameList;
import com.diegodev.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		
		List<GameList> list = gameListRepository.findAll();
		List<GameListDTO> dto = list.stream().map(x -> new GameListDTO(x)).toList();
		
		return dto ;
	}
	
	//é uma boa pratica colocar essa anotação para que o operação com o banco seja concreta (ASID)
	//Quando definido com readOnly = true, ela informa ao Spring que a operação não fará alterações no banco de dados
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		
		Optional<GameList> result = gameListRepository.findById(id);
		GameListDTO dto = new GameListDTO(result.get());
		
		return dto;
	}

}
