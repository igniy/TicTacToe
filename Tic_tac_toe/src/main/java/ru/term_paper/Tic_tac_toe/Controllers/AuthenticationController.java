package ru.term_paper.Tic_tac_toe.Controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.term_paper.Tic_tac_toe.Services.AuthenticationService;
import ru.term_paper.Tic_tac_toe.authentication.AuthenticationRequest;
import ru.term_paper.Tic_tac_toe.authentication.AuthenticationResponse;
import ru.term_paper.Tic_tac_toe.authentication.RegisterRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request) {
        return authenticationService.authenticate(request);
    }
}
