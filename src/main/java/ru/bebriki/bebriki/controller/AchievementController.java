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
@RequestMapping("/achievements")
public class AchievementController {

    @Autowired
    AchievementService achievementService;

    @GetMapping("/achievement/{id}")
    public Achievement getAchievementById(@PathVariable("id") int id) throws AchievementNotFoundException {
        return achievementService.getAchievementById(id);
    }

    @GetMapping()
    public List<Achievement> getAllAchievements() {
        return achievementService.getAllAchievements();
    }

    @PutMapping("achievement/{id}")
    public void updateAchievementById(@PathVariable("id") int id, @RequestBody Achievement achievement) throws AchievementNotFoundException {
        achievementService.updateAchievementById(id, achievement);
    }

    @PostMapping()
    public Achievement createAchievement(@RequestBody Achievement achievement) {
        return achievementService.createAchievement(achievement);
    }

    @DeleteMapping("/achievement/{id}")
    public void deleteAchievementById(@PathVariable("id") int id) {
        achievementService.deleteAchievementById(id);
    }

}
