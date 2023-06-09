package ru.bebriki.bebriki.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.Errors.WorkerNotFoundException;
import ru.bebriki.bebriki.Errors.WrongPasswordError;
import ru.bebriki.bebriki.dtos.WorkerDTO;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.repositories.WorkerRepository;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Integer signIn(String login, String password)
            throws WorkerNotFoundException, WrongPasswordError {
        Worker worker = workerRepository.findByLogin(login).get();
        if (workerRepository.findByLogin(login).isEmpty()) {
            throw new WorkerNotFoundException("nu such user");
        }
        if (!worker.getPassword().equals(password)) {
            throw new WrongPasswordError("wrong password");
        }
        return worker.getId();
    }
}
