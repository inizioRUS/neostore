package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.repositories.WorkerRepository;

import java.util.List;

public interface WorkerService {
    List<Worker> getWorkers();

    Worker getWorkerById(Integer id);

    Worker addWorker(Worker worker);

    void deleteWorkerById(Integer id);

    Worker updateWorker(Integer id, Worker worker);

    Worker getWorkerByLogin(String login);
}
