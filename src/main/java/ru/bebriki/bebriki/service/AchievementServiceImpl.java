package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.Errors.AchievementNotFoundException;
import ru.bebriki.bebriki.models.Achievement;
import ru.bebriki.bebriki.repositories.AchievementRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    AchievementRepository achievementRepository;

    @Override
    public Achievement getAchievementById(int id) throws AchievementNotFoundException {

        Optional<Achievement> achievement = achievementRepository.findById(id);

        if (achievement.isEmpty()) {
            throw new AchievementNotFoundException("There is no such department like this");
        }

        return achievement.get();

    }

    @Override
    public List<Achievement> getAllAchievements() {
        return achievementRepository.findAll();
    }

    @Override
    public void updateAchievementById(int id, Achievement achievement) throws AchievementNotFoundException {

        Achievement achievementDB = getAchievementById(id);

        if (Objects.nonNull(achievement.getName()) && !"".equalsIgnoreCase(achievement.getName())) {
            achievementDB.setName(achievement.getName());
        }

        if (Objects.nonNull(achievement.getDescription()) && !"".equalsIgnoreCase(achievement.getDescription())) {
            achievementDB.setDescription(achievement.getDescription());
        }

        if (Objects.nonNull(achievement.getImageURL()) && !"".equalsIgnoreCase(achievement.getImageURL())) {
            achievementDB.setImageURL(achievement.getImageURL());
        }

        achievementRepository.save(achievementDB);

    }

    @Override
    public Achievement createAchievement(Achievement achievement) {

        return achievementRepository.save(achievement);

    }

    @Override
    public void deleteAchievementById(int id) {
        achievementRepository.deleteById(id);
    }

}
