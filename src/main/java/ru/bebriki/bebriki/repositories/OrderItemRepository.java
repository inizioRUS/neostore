package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
