package com.diegodev.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegodev.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
