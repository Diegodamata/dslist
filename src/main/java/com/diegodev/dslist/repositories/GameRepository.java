package com.diegodev.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegodev.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
}
