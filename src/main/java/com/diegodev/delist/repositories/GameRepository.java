package com.diegodev.delist.repositories;

import com.diegodev.delist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
