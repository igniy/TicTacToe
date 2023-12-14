package ru.term_paper.Tic_tac_toe.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameResultRequest {
    private String username;
    private boolean isWinner;
}
