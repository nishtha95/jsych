package com.psych.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psych.game.model.Game;

public interface GameRepository extends JpaRepository<Game,Long> {

}
