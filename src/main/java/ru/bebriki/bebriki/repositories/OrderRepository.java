package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Order;
import ru.bebriki.bebriki.models.Task;

import java.time.LocalDateTime;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByData(LocalDateTime date);
}
