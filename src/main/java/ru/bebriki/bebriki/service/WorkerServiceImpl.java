package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.repositories.WorkerRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker getWorkerById(Integer id) {
        Optional<Worker> worker = workerRepository.findById(id);
        if (worker.isEmpty()) {
            throw new IllegalArgumentException("no such worker");
        }
        return worker.get();
    }

    @Override
    public void deleteWorkerById(Integer id) {
        workerRepository.deleteById(id);
    }

    @Override
    public Worker updateWorker(Integer id, Worker worker) {
        Worker workerDB = getWorkerById(id);
        if (Objects.nonNull(worker.getName()) && !"".equalsIgnoreCase(worker.getName())) {
            workerDB.setName(worker.getName());
        }
        if (Objects.nonNull(worker.getSurname()) && !"".equalsIgnoreCase(worker.getSurname())) {
            workerDB.setSurname(worker.getSurname());
        }
        if (Objects.nonNull(worker.getSecondName()) && !"".equalsIgnoreCase(worker.getSecondName())) {
            workerDB.setSecondName(worker.getSecondName());
        }
        if (Objects.nonNull(worker.getLogin()) && !"".equalsIgnoreCase(worker.getLogin())) {
            workerDB.setLogin(worker.getLogin());
        }
        if (Objects.nonNull(worker.getVacancyId()) && worker.getVacancyId() != 0) {
            workerDB.setVacancyId(worker.getVacancyId());
        }
        if (Objects.nonNull(worker.getPositionId()) && worker.getPositionId() != 0) {
            workerDB.setPositionId(worker.getPositionId());
        }
        if (Objects.nonNull(worker.getAge()) && worker.getAge() != 0) {
            workerDB.setAge(worker.getAge());
        }
        if (Objects.nonNull(worker.getAge()) && worker.getAge() != 0) {
            workerDB.setAge(worker.getAge());
        }
        if (Objects.nonNull(worker.getPhone()) && !"".equalsIgnoreCase(worker.getPhone())) {
            workerDB.setPhone(worker.getPhone());
        }
        if (Objects.nonNull(worker.getBalance()) && worker.getBalance() != 0) {
            workerDB.setBalance(worker.getBalance());
        }
        if (Objects.nonNull(worker.getPassword()) && !"".equalsIgnoreCase(worker.getPassword())) {
            workerDB.setPhone(worker.getPassword());
        }
        if (Objects.nonNull(worker.getRole()) && !"".equalsIgnoreCase(worker.getRole())) {
            workerDB.setRole(worker.getRole());
        }
        return workerRepository.save(workerDB);
    }

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker getWorkerByLogin(String login) {
        return workerRepository.findByLogin(login).orElse(null);
    }
}
