package com.diegodev.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diegodev.dslist.entities.Game;
import com.diegodev.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{
	
	//consulta customizada 
	
	//nativeQuery = true como não é o jpql o tipo de consulta do spring, utilizei apenas o sql
	//preciso colocar isso nativeQuery = true para funcionar a consulta SQL
	//porem quando eu uso esse parametro o resultado de consulta tem que ser uma interface(chamado de projection)
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId); //o parametro da minha lista é o que eu estou passando na consulta ':listId'
}
