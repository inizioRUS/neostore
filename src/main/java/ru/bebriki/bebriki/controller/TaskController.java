package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.Errors.TaskNotFoundException;
import ru.bebriki.bebriki.dtos.TaskDTO;
import ru.bebriki.bebriki.models.Task;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.service.TaskService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
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
//    public void changeBalance(Worker worker){
//        Task task = worker;
//        if(task.getIsDone()){
//            worker.setBalance(worker.getBalance()+addBalance(task));
//        }
//        else worker.setBalance(worker.getBalance()-decreaseBalance(task));
//    }
//    public void getDayNumberOld(List<Worker> workers) {
//        for(Worker w:workers){
//            LocalDate date = w.getTask().getDate();
//            if(date!=LocalDate.now()){
//                DayOfWeek day = date.getDayOfWeek();
//                if(day==DayOfWeek.MONDAY) changeBalance(w);
//            }
//        }
//    }
}
