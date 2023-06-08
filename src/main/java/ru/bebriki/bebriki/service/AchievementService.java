package ru.bebriki.bebriki.service;

import ru.bebriki.bebriki.Errors.AchievementNotFoundException;
import ru.bebriki.bebriki.models.Achievement;

import java.util.List;

public interface AchievementService {
    Achievement getAchievementById(int id) throws AchievementNotFoundException;

    List<Achievement> getAllAchievements();

    void updateAchievementById(int id, Achievement achievement) throws AchievementNotFoundException;

    Achievement createAchievement(Achievement achievement);

    void deleteAchievementById(int id);
}
