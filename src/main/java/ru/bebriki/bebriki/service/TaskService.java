package ru.bebriki.bebriki.service;

import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.models.Task;
import ru.bebriki.bebriki.models.Worker;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();

    Task getTaskByDifficulty(Integer difficulty);
    Task getTaskById(Integer id);
    Task updateTask(Integer id, Task task);
    void deleteTaskById(Integer id);
}
