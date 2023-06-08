package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Good;

public interface GoodRepository extends JpaRepository<Good, Integer> {

    Good findByName(String name);

}
