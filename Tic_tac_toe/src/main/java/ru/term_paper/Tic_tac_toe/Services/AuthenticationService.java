package ru.term_paper.Tic_tac_toe.Services;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.term_paper.Tic_tac_toe.JwtFiles.JwtService;
import ru.term_paper.Tic_tac_toe.Models.Player;
import ru.term_paper.Tic_tac_toe.authentication.AuthenticationRequest;
import ru.term_paper.Tic_tac_toe.authentication.AuthenticationResponse;
import ru.term_paper.Tic_tac_toe.authentication.PersonDetails;
import ru.term_paper.Tic_tac_toe.authentication.RegisterRequest;
import ru.term_paper.Tic_tac_toe.repositories.PlayerRepository;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PlayerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Player.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("ROLE_USER")
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(new PersonDetails(user));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(new PersonDetails(user));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
