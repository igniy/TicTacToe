package ru.term_paper.Tic_tac_toe.Controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.term_paper.Tic_tac_toe.Models.Game;
import ru.term_paper.Tic_tac_toe.Models.Player;
import ru.term_paper.Tic_tac_toe.Services.AuthenticatedPersonService;
import ru.term_paper.Tic_tac_toe.Services.GameService;
import ru.term_paper.Tic_tac_toe.requests.GameResultRequest;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    //private final PlayerStatisticsService playerStatisticsService;
    private final AuthenticatedPersonService authenticatedPersonService;




    @PostMapping("/game-result")
    public ResponseEntity<String> submitGameResult(@RequestBody Game game) {
        try {
            Player authenticatedPlayer = authenticatedPersonService.getAuthenticatedPlayer();

            game.setPlayer(authenticatedPlayer);

            gameService.submitGameResult(game);
            return ResponseEntity.ok("Игра добавлена");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при обработке запроса");
        }
    }
    @GetMapping("/games-list")
    public List<Game> getGames(){return gameService.findAll();}

}
