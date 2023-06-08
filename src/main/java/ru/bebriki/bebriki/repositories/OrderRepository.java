package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
