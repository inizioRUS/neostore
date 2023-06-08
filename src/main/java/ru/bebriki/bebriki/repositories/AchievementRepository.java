package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Integer> {
}
