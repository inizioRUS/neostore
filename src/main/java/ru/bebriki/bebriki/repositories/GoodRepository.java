package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.responses.CategoryItemResponse;

import java.util.List;

public interface GoodRepository extends JpaRepository<Good, Integer> {
    List<Good> findByTitle(@Param("title") String title);

    List<Good> findByCategory(String category);

    void deleteByTitle(@Param("title") String title);

}