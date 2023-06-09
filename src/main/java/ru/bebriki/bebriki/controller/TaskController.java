package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.Errors.TaskNotFoundException;
import ru.bebriki.bebriki.dtos.TaskDTO;
import ru.bebriki.bebriki.models.Task;
import ru.bebriki.bebriki.service.TaskService;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable("id") int id) throws TaskNotFoundException {
        return taskService.getTaskById(id);
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getTasks();
    }

    @PutMapping("/{id}")
    public void updateTaskById(@PathVariable("id") int id, @RequestBody TaskDTO taskDTO) throws TaskNotFoundException {
        taskService.updateTaskById(id, taskDTO);
    }

    @PostMapping
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        System.out.println("create method");
        return taskService.createTask(taskDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable("id") int id) throws TaskNotFoundException {
        taskService.deleteTaskById(id);
    }

    @GetMapping("/taskByDifficulty/{difficulty}")
    public List<Task> getTaskByDifficulty(@PathVariable("difficulty") int difficulty) throws TaskNotFoundException{
        return taskService.getTaskByDifficulty(difficulty);
    }

}
