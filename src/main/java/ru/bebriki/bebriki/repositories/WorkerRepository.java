package ru.bebriki.bebriki.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Optional<Worker> findByLogin(String login);
    List<Worker> findAllByOrderByBalanceDesc();
}
