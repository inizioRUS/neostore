package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.Errors.AchievementNotFoundException;
import ru.bebriki.bebriki.models.Achievement;
import ru.bebriki.bebriki.models.Task;
import ru.bebriki.bebriki.service.TaskService;
import ru.bebriki.bebriki.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") int id) throws AchievementNotFoundException {
        return taskService.getTaskById(id);
    }
    @GetMapping("/taskByDifficulty/{difficulty}")
    public Task getTaskByDifficulty(@PathVariable("difficulty") int difficulty) throws AchievementNotFoundException{
        return taskService.getTaskByDifficulty(difficulty);
    }
    @PutMapping("/update/{id}")
    public void updateTask(@PathVariable("id") int id, @RequestBody Task task) throws AchievementNotFoundException {
        taskService.updateTask(id, task);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteTaskById(@PathVariable("id") int id) {
        taskService.deleteTaskById(id);
    }
}
