package ru.term_paper.Tic_tac_toe.Services;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.term_paper.Tic_tac_toe.Models.Player;
import ru.term_paper.Tic_tac_toe.authentication.PersonDetails;

@Service
public class AuthenticatedPersonService {
    public Player getAuthenticatedPlayer() {
        PersonDetails personDetails = (PersonDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return personDetails.getPlayer();
    }
}