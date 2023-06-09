package ru.bebriki.bebriki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bebriki.bebriki.models.Position;
import ru.bebriki.bebriki.models.Post;
import ru.bebriki.bebriki.repositories.PositionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Position getPositionById(int id) {

        Optional<Position> position = positionRepository.findById(id);

        if (position.isEmpty()) {
            throw new IllegalArgumentException("There is no such achievement like this");
        }

        return position.get();
    }


    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Position getPositionByName(String name) {

        Position position = positionRepository.findByName(name);

        if (position == null) {
            throw new IllegalArgumentException("There is no such position like this");
        }

        return position;
    }

    @Override
    public void deletePositionById(int id) {
        if (positionRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("no such task");
        }
        positionRepository.deleteById(id);
    }

    @Override
    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }
}
