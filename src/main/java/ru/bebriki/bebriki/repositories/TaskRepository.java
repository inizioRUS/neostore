package ru.bebriki.bebriki.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Task;
import ru.bebriki.bebriki.models.Worker;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByDifficulty(Integer difficulty);

    Task findByWorkerId(Integer id);

    Task findTaskByWorkerId(Integer id);

}
