package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.dtos.WorkerDTO;
import ru.bebriki.bebriki.models.Position;
import ru.bebriki.bebriki.models.Post;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.repositories.PositionRepository;
import ru.bebriki.bebriki.repositories.PostRepository;
import ru.bebriki.bebriki.repositories.WorkerRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private PostRepository postRepository;

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
        if (Objects.nonNull(worker.getPostId()) && worker.getPostId() != 0) {
            workerDB.setPostId(worker.getPostId());
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

    @Override
    public WorkerDTO toDTO(Worker worker) {
        Position position = positionRepository.findById(worker.getPositionId()).get();
        Post post = postRepository.findById(worker.getPostId()).get();

        return WorkerDTO.builder()
                .id(worker.getId())
                .name(worker.getName())
                .surname(worker.getSurname())
                .secondName(worker.getSecondName())
                .login(worker.getLogin())
                .post(post.getName())
                .position(position.getName())
                .age(worker.getAge())
                .phone(worker.getPhone())
                .balance(worker.getBalance())
                .password(worker.getPassword())
                .role(worker.getRole())
                .gender(worker.getGender())
                .build();
    }
}
