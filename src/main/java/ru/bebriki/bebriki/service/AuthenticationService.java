package ru.bebriki.bebriki.service;

import ru.bebriki.bebriki.Errors.WorkerNotFoundException;
import ru.bebriki.bebriki.Errors.WrongPasswordError;

public interface AuthenticationService {
    Integer signIn(String login, String password)
            throws WorkerNotFoundException, WrongPasswordError;
}
