package ru.bebriki.bebriki.service;

import ru.bebriki.bebriki.models.Position;
import ru.bebriki.bebriki.models.Post;

import java.util.List;

public interface PositionService {

    Position getPositionById(int id);

    List<Position> getAllPositions();

    Position getPositionByName(String name);

    void deletePositionById(int id);

    Position createPosition(Position position);

}
