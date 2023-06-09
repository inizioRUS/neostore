package ru.bebriki.bebriki.service;

import ru.bebriki.bebriki.Errors.TaskNotFoundException;
import ru.bebriki.bebriki.dtos.TaskDTO;
import ru.bebriki.bebriki.models.Task;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getTasks();

    TaskDTO getTaskById(Integer id) throws TaskNotFoundException;

    void deleteTaskById(Integer id) throws TaskNotFoundException;

    TaskDTO updateTaskById(Integer id, TaskDTO workerDTO) throws TaskNotFoundException;

    TaskDTO createTask(TaskDTO workerDTO);

    TaskDTO toDTO(Task task);

    Task toTask(TaskDTO taskDTO);
}
