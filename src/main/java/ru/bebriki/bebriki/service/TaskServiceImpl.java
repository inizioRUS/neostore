package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.bebriki.bebriki.Errors.TaskNotFoundException;
import ru.bebriki.bebriki.dtos.TaskDTO;
import ru.bebriki.bebriki.dtos.WorkerDTO;
import ru.bebriki.bebriki.models.Post;
import ru.bebriki.bebriki.models.Task;
import ru.bebriki.bebriki.models.Worker;
import ru.bebriki.bebriki.repositories.PostRepository;
import ru.bebriki.bebriki.repositories.TaskRepository;
import ru.bebriki.bebriki.repositories.WorkerRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public TaskDTO getTaskById(Integer id) throws TaskNotFoundException {
        Optional<Task> worker = taskRepository.findById(id);
        if (worker.isEmpty()) {
            throw new TaskNotFoundException("no such task");
        }
        return toDTO(worker.get());
    }

    @Override
    public void deleteTaskById(Integer id) throws TaskNotFoundException {
        if (taskRepository.findById(id).isEmpty()) {
            throw new TaskNotFoundException("no such task");
        }
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDTO updateTaskById(Integer id, TaskDTO workerDTO) throws TaskNotFoundException {

        TaskDTO workerDB = getTaskById(id);

        if (Objects.nonNull(workerDTO.getName()) && !"".equalsIgnoreCase(workerDTO.getName())) {
            workerDB.setName(workerDTO.getName());
        }
        if (Objects.nonNull(workerDTO.getDescription()) && !"".equalsIgnoreCase(workerDTO.getDescription())) {
            workerDB.setDescription(workerDTO.getDescription());
        }
        if (Objects.nonNull(workerDTO.getIsDone())) {
            workerDB.setIsDone(workerDTO.getIsDone());
        }
        if (Objects.nonNull(workerDTO.getDifficulty()) && (workerDTO.getDifficulty()) != 0) {
            workerDB.setDifficulty(workerDTO.getDifficulty());
        }
        if (Objects.nonNull(workerDTO.getPostName()) && !"".equalsIgnoreCase(workerDTO.getPostName())) {
            workerDB.setPostName(workerDTO.getPostName());
        }
        if (Objects.nonNull(workerDTO.getPostName()) && !"".equalsIgnoreCase(workerDTO.getPostName())) {
            workerDB.setPostName(workerDTO.getPostName());
        }

        taskRepository.save(toTask(workerDB));
        return workerDB;
    }

    @Override
    public TaskDTO createTask(TaskDTO workerDTO) {
        taskRepository.save(toTask(workerDTO));
        return workerDTO;
    }

    @Override
    public TaskDTO toDTO(Task task) {

        System.out.println(task.getWorkerId());

        Optional<Post> post = postRepository.findById(task.getPostId());
        Optional<Worker> worker = workerRepository.findById(task.getWorkerId());


        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .difficulty(task.getDifficulty())
                .isDone(task.getIsDone())
                .postName(post.get().getName())
                .date(task.getDate())
                .workerId(worker.get().getId())
                .build();
    }

    @Override
    public Task toTask(TaskDTO taskDTO) {
        Post post = postRepository.findByName(taskDTO.getPostName());
        Optional<Worker> worker = workerRepository.findById(taskDTO.getWorkerId());
        return Task.builder()
                .id(taskDTO.getId())
                .name(taskDTO.getName())
                .description(taskDTO.getDescription())
                .difficulty(taskDTO.getDifficulty())
                .isDone(taskDTO.getIsDone())
                .postId(post.getId())
                .workerId(worker.get().getId())

                .date(taskDTO.getDate())

                .build();
    }

    @Override
    public List<Task> getTaskByDifficulty(Integer difficulty) {
        List<Task> task = taskRepository.findByDifficulty(difficulty);
        if(task.isEmpty()){
            throw new IllegalArgumentException("no such difficult task");
        }
        return task;

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
    public void changeBalance(WorkerDTO worker){
        Task task = taskRepository.findTaskByWorkerId(worker.getId());
        if(task.getIsDone()){
            worker.setBalance(worker.getBalance()+addBalance(task));
        }
        else worker.setBalance(worker.getBalance()-decreaseBalance(task));
    }

}
