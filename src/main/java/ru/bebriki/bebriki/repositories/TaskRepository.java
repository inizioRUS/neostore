package ru.bebriki.bebriki.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Task;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByDifficulty(Integer difficulty);

}
