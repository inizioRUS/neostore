package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.Errors.WorkerNotFoundException;
import ru.bebriki.bebriki.dtos.WorkerDTO;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.repositories.WorkerRepository;

import java.util.List;

public interface WorkerService {
    List<WorkerDTO> getWorkers();

    WorkerDTO getWorkerById(Integer id) throws WorkerNotFoundException;

    WorkerDTO addWorker(WorkerDTO workerDTO);

    void deleteWorkerById(Integer id) throws WorkerNotFoundException;

    WorkerDTO updateWorker(Integer id, WorkerDTO workerDTO);

    WorkerDTO getWorkerByLogin(String login) throws WorkerNotFoundException;

    WorkerDTO toDTO(Worker worker);

    Worker toWorker(WorkerDTO workerDTO);
}
