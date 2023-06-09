package ru.bebriki.bebriki.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.Errors.AchievementNotFoundException;
import ru.bebriki.bebriki.models.Achievement;
import ru.bebriki.bebriki.repositories.AchievementRepository;
import ru.bebriki.bebriki.service.AchievementService;
import ru.bebriki.bebriki.service.AchievementServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping("/achievements/{id}")
    public Achievement getAchievementById(@PathVariable("id") int id) throws AchievementNotFoundException {
        return achievementService.getAchievementById(id);
    }

    @GetMapping("/achievements")
    public List<Achievement> getAllAchievements() {
        return achievementService.getAllAchievements();
    }

    @PutMapping("/achievements/{id}")
    public void updateAchievementById(@PathVariable("id") int id, @RequestBody Achievement achievement) throws AchievementNotFoundException {
        achievementService.updateAchievementById(id, achievement);
    }

    @PostMapping("/achievements")
    public Achievement createAchievement(@RequestBody Achievement achievement) {
        System.out.println("create method");
        return achievementService.createAchievement(achievement);
    }

    @DeleteMapping("/achievements/{id}")
    public void deleteAchievementById(@PathVariable("id") int id) throws AchievementNotFoundException {
        achievementService.deleteAchievementById(id);
    }

}
