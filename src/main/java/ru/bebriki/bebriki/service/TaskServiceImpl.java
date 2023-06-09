package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.Errors.TaskNotFoundException;
import ru.bebriki.bebriki.dtos.TaskDTO;
import ru.bebriki.bebriki.models.Post;
import ru.bebriki.bebriki.models.Task;
import ru.bebriki.bebriki.repositories.PostRepository;
import ru.bebriki.bebriki.repositories.TaskRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public TaskDTO getTaskById(Integer id) throws TaskNotFoundException {
        Optional<Task> worker = taskRepository.findById(id);
        if (worker.isEmpty()) {
            throw new TaskNotFoundException("no such task");
        }
        return toDTO(worker.get());
    }

    @Override
    public void deleteTaskById(Integer id) throws TaskNotFoundException {
        if (taskRepository.findById(id).isEmpty()) {
            throw new TaskNotFoundException("no such task");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDTO updateTaskById(Integer id, TaskDTO workerDTO) throws TaskNotFoundException {

        TaskDTO workerDB = getTaskById(id);

        if (Objects.nonNull(workerDTO.getName()) && !"".equalsIgnoreCase(workerDTO.getName())) {
            workerDB.setName(workerDTO.getName());
        }
        if (Objects.nonNull(workerDTO.getDescription()) && !"".equalsIgnoreCase(workerDTO.getDescription())) {
            workerDB.setDescription(workerDTO.getDescription());
        }
        if (Objects.nonNull(workerDTO.getIsDone())) {
            workerDB.setIsDone(workerDTO.getIsDone());
        }
        if (Objects.nonNull(workerDTO.getDifficulty()) && (workerDTO.getDifficulty()) != 0) {
            workerDB.setDifficulty(workerDTO.getDifficulty());
        }
        if (Objects.nonNull(workerDTO.getPostName()) && !"".equalsIgnoreCase(workerDTO.getPostName())) {
            workerDB.setPostName(workerDTO.getPostName());
        }

        taskRepository.save(toTask(workerDB));
        return workerDB;
    }

    @Override
    public TaskDTO createTask(TaskDTO workerDTO) {
        taskRepository.save(toTask(workerDTO));
        return workerDTO;
    }

    @Override
    public TaskDTO toDTO(Task task) {
        Post post = postRepository.findById(task.getPostId()).get();

        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .difficulty(task.getDifficulty())
                .isDone(task.getIsDone())
                .build();
    }

    @Override
    public Task toTask(TaskDTO taskDTO) {
        Optional<Post> post = postRepository.findById(taskDTO.getId());
        return Task.builder()
                .id(taskDTO.getId())
                .name(taskDTO.getName())
                .description(taskDTO.getDescription())
                .difficulty(taskDTO.getDifficulty())
                .isDone(taskDTO.getIsDone())
                .build();
    }

}
