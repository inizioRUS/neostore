package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.service.WorkerService;

import java.util.List;


@RestController
@RequestMapping("/users")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @GetMapping
    public List<Worker> getWorkers() {
        return workerService.getWorkers();
    }

    @GetMapping("/worker/{id}")
    public Worker getWorkerById(@PathVariable Integer id) {
        return workerService.getWorkerById(id);
    }

    @PostMapping("/addWorker")
    public Worker addWorker(@RequestBody Worker worker) {
        return workerService.addWorker(worker);
    }

    @DeleteMapping("/worker/{id}")
    public void deleteWorkerById(@PathVariable Integer id) {
        workerService.deleteWorkerById(id);
    }

    @PutMapping("/worker/{id}")
    public Worker updateWorker(@PathVariable Integer id, @RequestBody Worker worker) {
        return workerService.updateWorker(id, worker);
    }

    @GetMapping("/worker/{login}")
    public Worker getWorkerByLogin(@PathVariable String login) {
        return workerService.getWorkerByLogin(login);
    }
}
