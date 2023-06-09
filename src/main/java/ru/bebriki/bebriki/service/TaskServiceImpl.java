package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskByDifficulty(Integer difficulty) {
        return taskRepository.findByDifficulty(difficulty).orElse(null);
    }

    @Override
    public Task getTaskById(Integer id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new IllegalArgumentException("no such task");
        }
        return task.get();
    }

    @Override
    public Task updateTask(Integer id, Task task) {
        Task taskDB = getTaskById(id);
        if (Objects.nonNull(task.getName()) && !"".equalsIgnoreCase(task.getName())) {
            taskDB.setName(task.getName());
        }
        if (Objects.nonNull(task.getDescription()) && !"".equalsIgnoreCase(task.getDescription())) {
            taskDB.setDescription(task.getDescription());
        }
        if (Objects.nonNull(task.getDifficulty()) && task.getDifficulty() != 0) {
            taskDB.setDifficulty(task.getDifficulty());
        }
        if (Objects.nonNull(task.getIsDone())) {
            taskDB.setIsDone(task.getIsDone());
        }
        if(Objects.nonNull(task.getWorker())){
            taskDB.setWorker(task.getWorker());
        }
        return taskRepository.save(taskDB);
    }

    @Override
    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }
}
