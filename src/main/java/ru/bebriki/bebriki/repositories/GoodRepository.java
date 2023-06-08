package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Good;

import java.util.List;

public interface GoodRepository extends JpaRepository<Good, Integer> {

    List<Good> findByName(String name);

}
