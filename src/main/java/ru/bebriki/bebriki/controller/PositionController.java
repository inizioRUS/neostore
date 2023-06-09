package ru.bebriki.bebriki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bebriki.bebriki.models.Position;
import ru.bebriki.bebriki.models.Post;
import ru.bebriki.bebriki.service.PositionService;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/{id}")
    public Position getPositionById(@PathVariable("id") int id) {
        return positionService.getPositionById(id);
    }

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/name")
    public Position getPositionByName(@RequestParam String name) {
        return positionService.getPositionByName(name);
    }

    @DeleteMapping("/{id}")
    public void deletePositionById(@PathVariable("id") int id) {
        positionService.deletePositionById(id);
    }

    @PostMapping
    public Position createPosition(@RequestBody Position position) {
        return positionService.createPosition(position);
    }

}
