package ru.term_paper.Tic_tac_toe.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.term_paper.Tic_tac_toe.Models.Player;
import ru.term_paper.Tic_tac_toe.Services.PlayerService;
import ru.term_paper.Tic_tac_toe.requests.PlayerStatisticsResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/{username}")
    public Optional<Player> getPlayerByUsername(@PathVariable String username) {
        return playerService.getPlayerByUsername(username);
    }

    @GetMapping("/playerlist")
    public List<Player> getPlayers() {
        return playerService.findAll();
    }
//
//    @GetMapping("/player-statistics")
//    public ResponseEntity<PlayerStatisticsResponse> getPlayerStatistics() {
//
//        PlayerStatisticsResponse statistics = /* Логика получения статистики */;
//        return ResponseEntity.ok(statistics);
//    }
}

