package ru.term_paper.Tic_tac_toe.Services;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.term_paper.Tic_tac_toe.Models.Game;
import ru.term_paper.Tic_tac_toe.Models.Player;
import ru.term_paper.Tic_tac_toe.repositories.GameRepository;
import ru.term_paper.Tic_tac_toe.repositories.PlayerRepository;
import ru.term_paper.Tic_tac_toe.requests.GameResultRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    private final PlayerRepository playerRepository;

    public ResponseEntity<String> submitGameResult(Game game) {
        gameRepository.save(game);

        Player gameCounter = game.getPlayer();
        int numberOfGames = gameCounter.getGamesPlayed() + 1;
        gameCounter.setGamesPlayed(numberOfGames);

        if (game.isWinner()){
            int numberOfWins = gameCounter.getGamesWon() + 1;
            gameCounter.setGamesWon(numberOfWins);
        }

        playerRepository.save(gameCounter);

        return ResponseEntity.ok("Игра добавлена, игры и победы посчитаны");
    }
    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
