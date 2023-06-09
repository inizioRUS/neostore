package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findByName(String name);
}
