package ru.term_paper.Tic_tac_toe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.term_paper.Tic_tac_toe.Models.Game;
import ru.term_paper.Tic_tac_toe.Models.Player;
import ru.term_paper.Tic_tac_toe.repositories.GameRepository;
import ru.term_paper.Tic_tac_toe.repositories.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    public Optional<Player> getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player updatePlayerStats(Player player, boolean isWinner) {
        player.setGamesPlayed(player.getGamesPlayed() + 1);
        if (isWinner) {
            player.setGamesWon(player.getGamesWon() + 1);
        }
        return playerRepository.save(player);
    }

//    public void saveGameResult(Player player, boolean isWinner) {
//        Game game = new Game();
//        game.setPlayer(player);
//        game.setWinner(isWinner);
//        gameRepository.save(game);
//    }


    // добавь методы для работы с игроками, например, регистрация, получение статистики и т.д.

}
