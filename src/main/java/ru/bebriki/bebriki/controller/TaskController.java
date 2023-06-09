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

    @PostMapping("/createTask")
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        System.out.println("create method");
        return taskService.createTask(taskDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable("id") int id) throws TaskNotFoundException {
        taskService.deleteTaskById(id);
    }

    @GetMapping("/taskByDifficulty")
    public List<Task> getTaskByDifficulty(@RequestParam("difficulty") int difficulty) throws TaskNotFoundException{
        return taskService.getTaskByDifficulty(difficulty);
    }

    public int addBalance(Task task){
        if(task.getDifficulty()==1) return 5;
        if(task.getDifficulty()==2) return 15;
        return 25;
    }
    public int decreaseBalance(Task task){
        if(task.getDifficulty()==1) return 12;
        if(task.getDifficulty()==2) return 7;
        return 3;
    }
    public boolean isDone(){
        if(this.isDone()) return true;
        return false;
    }
    public void changeBalance(Task task){
        if(task.getIsDone()){
            task.getWorker().setBalance(task.getWorker().getBalance()+addBalance(task));
        }
        else task.getWorker().setBalance(task.getWorker().getBalance()-decreaseBalance(task));
    }
//    public static int getDayNumberOld(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        return cal.get(Calendar.DAY_OF_WEEK);
//    }
}
