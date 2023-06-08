package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Wish;

public interface WishRepository extends JpaRepository<Wish, Integer> {
}
