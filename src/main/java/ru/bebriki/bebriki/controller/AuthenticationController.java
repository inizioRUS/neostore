package ru.bebriki.bebriki.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.Errors.WorkerNotFoundException;
import ru.bebriki.bebriki.Errors.WrongPasswordError;
import ru.bebriki.bebriki.requests.AuthenticationRequest;
import ru.bebriki.bebriki.service.AuthenticationService;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signin")
    Integer signIn(AuthenticationRequest authenticationRequest)
            throws WorkerNotFoundException, WrongPasswordError {
        return authenticationService
                .signIn(authenticationRequest.getLogin(),
                        authenticationRequest.getPassword());
    }
}
