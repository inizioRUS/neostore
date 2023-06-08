package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.responses.CategoryItemResponse;

import java.util.List;

public interface GoodRepository extends JpaRepository<Good, Integer> {

    List<Good> findByName(String name);
    List<Good> findByTitle(@Param("title") String title);
    @Query("SELECT new com.example.demo.responses.CategoryItemResponse(p.category, " +
            "COUNT(*) as amount) FROM goods AS p GROUP BY p.category ORDER BY amount DESC")
    List<CategoryItemResponse> findProductCategories();

    void deleteByTitle(@Param("title") String title);

}