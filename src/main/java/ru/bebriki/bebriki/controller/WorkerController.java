package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.Errors.WorkerNotFoundException;
import ru.bebriki.bebriki.dtos.WorkerDTO;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.service.WorkerService;

import java.util.List;


@RestController
@RequestMapping("/workers")
@CrossOrigin
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @GetMapping
    public List<WorkerDTO> getWorkers() {
        return workerService.getWorkers();
    }

    @GetMapping("/worker/id/{id}")
    public WorkerDTO getWorkerById(@PathVariable("id") int id) throws WorkerNotFoundException {
        return workerService.getWorkerById(id);
    }

    @PostMapping
    public WorkerDTO addWorker(@RequestBody WorkerDTO workerDTO) {
        return workerService.addWorker(workerDTO);
    }

    @DeleteMapping("/worker/{id}")
    public void deleteWorkerById(@PathVariable Integer id) throws WorkerNotFoundException {
        workerService.deleteWorkerById(id);
    }

    @PutMapping("/worker/{id}")
    public WorkerDTO updateWorker(@PathVariable Integer id, @RequestBody WorkerDTO workerDTO) {
        return workerService.updateWorker(id, workerDTO);
    }

    @GetMapping("/worker")
    public WorkerDTO getWorkerByLogin(@RequestParam String login) throws WorkerNotFoundException {
        return workerService.getWorkerByLogin(login);
    }

    @GetMapping("/orderByBalance")
    public List<WorkerDTO> findAllByOrderByBalanceDesc() {
        return workerService.findAllByOrderByBalanceDesc();
    }
}
