package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.Errors.WorkerNotFoundException;
import ru.bebriki.bebriki.dtos.WorkerDTO;
import ru.bebriki.bebriki.models.Position;
import ru.bebriki.bebriki.models.Post;
import ru.bebriki.bebriki.models.Task;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.repositories.PositionRepository;
import ru.bebriki.bebriki.repositories.PostRepository;
import ru.bebriki.bebriki.repositories.TaskRepository;
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
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<WorkerDTO> getWorkers() {
        return workerRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public WorkerDTO getWorkerById(Integer id) {
        Optional<Worker> worker = workerRepository.findById(id);
        if (worker.isEmpty()) {
            throw new IllegalArgumentException("no such worker");
        }
        return toDTO(worker.get());
    }

    @Override
    public void deleteWorkerById(Integer id) throws WorkerNotFoundException {
        if (workerRepository.findById(id).isEmpty()) {
            throw new WorkerNotFoundException("no such user");
        }
        workerRepository.deleteById(id);
    }

    @Override
    public WorkerDTO updateWorker(Integer id, WorkerDTO workerDTO) {
        WorkerDTO workerDB = getWorkerById(id);
        if (Objects.nonNull(workerDTO.getName()) && !"".equalsIgnoreCase(workerDTO.getName())) {
            workerDB.setName(workerDTO.getName());
        }
        if (Objects.nonNull(workerDTO.getSurname()) && !"".equalsIgnoreCase(workerDTO.getSurname())) {
            workerDB.setSurname(workerDTO.getSurname());
        }
        if (Objects.nonNull(workerDTO.getSecondName()) && !"".equalsIgnoreCase(workerDTO.getSecondName())) {
            workerDB.setSecondName(workerDTO.getSecondName());
        }
        if (Objects.nonNull(workerDTO.getLogin()) && !"".equalsIgnoreCase(workerDTO.getLogin())) {
            workerDB.setLogin(workerDTO.getLogin());
        }
        if (Objects.nonNull(workerDTO.getPost()) && !"".equalsIgnoreCase(workerDTO.getPost())) {
            workerDB.setPost(workerDTO.getPost());
        }
        if (Objects.nonNull(workerDTO.getPosition()) && !"".equalsIgnoreCase(workerDTO.getPosition())) {
            workerDB.setPosition(workerDTO.getPosition());
        }
        if (Objects.nonNull(workerDTO.getAge()) && workerDTO.getAge() != 0) {
            workerDB.setAge(workerDTO.getAge());
        }
        if (Objects.nonNull(workerDTO.getAge()) && workerDTO.getAge() != 0) {
            workerDB.setAge(workerDTO.getAge());
        }
        if (Objects.nonNull(workerDTO.getPhone()) && !"".equalsIgnoreCase(workerDTO.getPhone())) {
            workerDB.setPhone(workerDTO.getPhone());
        }
        if (Objects.nonNull(workerDTO.getBalance()) && workerDTO.getBalance() != 0) {
            workerDB.setBalance(workerDTO.getBalance());
        }
        if (Objects.nonNull(workerDTO.getPassword()) && !"".equalsIgnoreCase(workerDTO.getPassword())) {
            workerDB.setPhone(workerDTO.getPassword());
        }
        if (Objects.nonNull(workerDTO.getRole()) && !"".equalsIgnoreCase(workerDTO.getRole())) {
            workerDB.setRole(workerDTO.getRole());
        }
        workerRepository.save(toWorker(workerDB));
        return workerDB;
    }

    @Override
    public WorkerDTO addWorker(WorkerDTO workerDTO) {
        workerRepository.save(toWorker(workerDTO));
        return workerDTO;
    }

    @Override
    public WorkerDTO getWorkerByLogin(String login) throws WorkerNotFoundException {
        if (workerRepository.findByLogin(login).isEmpty()) {
            throw new WorkerNotFoundException("nu such user");
        }
        return toDTO(workerRepository.findByLogin(login).get());
    }

    @Override
    public List<WorkerDTO> findAllByOrderByBalanceDesc() {
        return workerRepository.findAllByOrderByBalanceDesc().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public WorkerDTO toDTO(Worker worker) {
        Position position = positionRepository.findById(worker.getPositionId()).get();
        Post post = postRepository.findById(worker.getPostId()).get();
        Task task = taskRepository.findByWorkerId(worker.getId());

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
                .goods(worker.getGoods())
                .task(task)
                .build();
    }

    @Override
    public Worker toWorker(WorkerDTO workerDTO) {
        Position position = positionRepository.findByName(workerDTO.getPosition());
        Post post = postRepository.findByName(workerDTO.getPost());
        return Worker.builder()
                .id(workerDTO.getId())
                .name(workerDTO.getName())
                .surname(workerDTO.getSurname())
                .secondName(workerDTO.getSecondName())
                .login(workerDTO.getLogin())
                .postId(post.getId())
                .positionId(position.getId())
                .age(workerDTO.getAge())
                .phone(workerDTO.getPhone())
                .balance(workerDTO.getBalance())
                .password(workerDTO.getPassword())
                .role(workerDTO.getRole())
                .gender(workerDTO.getGender())
                .goods(workerDTO.getGoods())
                .taskId(workerDTO.getTask().getId())
                .build();
    }
}
