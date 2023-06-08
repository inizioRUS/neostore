package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
