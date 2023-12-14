package ru.term_paper.Tic_tac_toe.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.term_paper.Tic_tac_toe.Models.Game;
import ru.term_paper.Tic_tac_toe.Models.Player;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
