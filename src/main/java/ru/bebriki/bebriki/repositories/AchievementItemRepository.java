package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.AchievementItem;

public interface AchievementItemRepository extends JpaRepository<AchievementItem, Integer> {
}
