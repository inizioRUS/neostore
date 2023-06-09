package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.Errors.AchievementNotFoundException;
import ru.bebriki.bebriki.Errors.TaskNotFoundException;
import ru.bebriki.bebriki.dtos.TaskDTO;
import ru.bebriki.bebriki.models.Achievement;
import ru.bebriki.bebriki.models.Task;
import ru.bebriki.bebriki.service.TaskService;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{id}")
    public TaskDTO getTaskById(@PathVariable("id") int id) throws TaskNotFoundException {
        return taskService.getTaskById(id);
    }

    @GetMapping("/tasks")
    public List<TaskDTO> getAllTasks() {
        return taskService.getTasks();
    }

    @PutMapping("/tasks/{id}")
    public void updateTaskById(@PathVariable("id") int id, @RequestBody TaskDTO taskDTO) throws TaskNotFoundException {
        taskService.updateTaskById(id, taskDTO);
    }

    @PostMapping("/tasks")
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        System.out.println("create method");
        return taskService.createTask(taskDTO);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskById(@PathVariable("id") int id) throws TaskNotFoundException {
        taskService.deleteTaskById(id);
    }

}
